package com.fulrich.aoc.cli

import org.rogach.scallop._
import com.fulrich.aoc.input._
import com.fulrich.aoc.{ExecutionSelecting, AocDefaults}

class PuzzleSubcommand(aocDefaults: AocDefaults = new AocDefaults) extends Subcommand("puzzle") with ExecutionSelecting with InputConfiguration(aocDefaults) {
  val day = opt[Int](
    descr = "Choose which day to solve.",
    default = Some(aocDefaults.day),
    validate = value => value >= 1 && value <= 25
  )

  val part = opt[Int](descr = "Choose which part of the day to solve.",
    default = Some(1),
    validate = value => value == 1 || value == 2
  )

  def selection: ExecutionSelection = AocPuzzle(
    day = day(),
    part = part(),
    data = DataInput(inputRequest(day(), part()))
  )
}