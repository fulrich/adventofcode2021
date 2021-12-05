package com.fulrich.aoc.output

import com.fulrich.aoc.input.AocPuzzle
import com.fulrich.aoc.input.SubmarineCommand
import io.AnsiColor._

trait ExecutionResult[A : Serialization]:
  val puzzleHeaderSegment = s"${GREEN}.:${RED}*${GREEN}~${RED}*${GREEN}:.${RESET}"
  val puzzleHeaderSide = Seq.fill(3)(puzzleHeaderSegment).mkString(s"${GREEN}_")
  def header(title: String): String = s"$puzzleHeaderSide ${RED}${title} $puzzleHeaderSide"

  def output: Unit

case class AocPuzzleResult[A : Serialization](result: A)(implicit input: AocPuzzle) extends ExecutionResult[A]:
  override def output: Unit = {
    println(header("AoC 2021 Puzzle"))
    println(s"${GREEN}Day ${RED}${input.day} ${GREEN}- Part ${RED}${input.part}")
    println(s"${GREEN}Answer: ${RED}${summon[Serialization[A]].serialize(result)}${RESET}")
  }

case class SubmarineResult[A: Serialization](result: A)(implicit input: SubmarineCommand) extends ExecutionResult[A]:
  override def output: Unit = {
    println(header("Santa's Submarine Command"))
    println(s"${GREEN}Executing Command: ${RED}${input.command}")
    println(s"${GREEN}${summon[Serialization[A]].serialize(result)}")
  }

case class UnknownResult(error: String) extends ExecutionResult[String]:
  override def output: Unit = println(error)

object ExecutionResult:
  implicit def toSubmarineResult[A: Serialization](result: A)(implicit input: SubmarineCommand): SubmarineResult[A] = 
    SubmarineResult(result)
  
  implicit def toAocPuzzleResult[A: Serialization](result: A)(implicit input: AocPuzzle): AocPuzzleResult[A] = 
    AocPuzzleResult(result)