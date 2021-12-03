package com.fulrich.aoc.output

import com.fulrich.aoc.input.AocPuzzle
import com.fulrich.aoc.input.SubmarineCommand

trait ExecutionResult[A]:
  def output: Unit

case class AocPuzzleResult[A](result: A, input: AocPuzzle) extends ExecutionResult[A]:
  override def output: Unit = {
    println("##### AoC Puzzle #####")
    println(s"Day ${input.day} - Part ${input.part}")
    println(s"Answer: $result")
  }

case class SubmarineResult[A](result: A, input: SubmarineCommand) extends ExecutionResult[A]:
  override def output: Unit = {
    println("##### Submarine Command #####")
    println(s"Executing Command: ${input.command}")
    println(s"Result: $result")
  }

case class UnknownResult(error: String) extends ExecutionResult[String]:
  override def output: Unit = println(error)