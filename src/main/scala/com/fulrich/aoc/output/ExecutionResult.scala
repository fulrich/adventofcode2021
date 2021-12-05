package com.fulrich.aoc.output

import com.fulrich.aoc.input.AocPuzzle
import com.fulrich.aoc.input.SubmarineCommand

trait ExecutionResult[A]:
  def output: Unit

case class AocPuzzleResult[A](result: A)(implicit input: AocPuzzle) extends ExecutionResult[A]:
  override def output: Unit = {
    println("##### AoC Puzzle #####")
    println(s"Day ${input.day} - Part ${input.part}")
    println(s"Answer: $result")
  }

case class SubmarineResult[A](result: A)(implicit input: SubmarineCommand) extends ExecutionResult[A]:
  override def output: Unit = {
    println("##### Submarine Command #####")
    println(s"Executing Command: ${input.command}")
    println(s"Result: $result")
  }

case class UnknownResult(error: String) extends ExecutionResult[String]:
  override def output: Unit = println(error)

object ExecutionResult:
  implicit def toSubmarineResult[A](result: A)(implicit input: SubmarineCommand): SubmarineResult[A] = 
    SubmarineResult(result)
  
  implicit def toAocPuzzleResult[A](result: A)(implicit input: AocPuzzle): AocPuzzleResult[A] = 
    AocPuzzleResult(result)