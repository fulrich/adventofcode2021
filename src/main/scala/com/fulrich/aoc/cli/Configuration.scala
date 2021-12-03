package com.fulrich.aoc.cli

import org.rogach.scallop._
import com.fulrich.aoc.input._
import com.fulrich.aoc.ExecutionSelecting
import com.fulrich.aoc.AocDefaults

class Configuration(arguments: Seq[String], aocDefaults: AocDefaults = new AocDefaults) extends ScallopConf(arguments) with ExecutionSelecting {
  printedName = "Santa's Submarine | AoC 2021"
  banner("""CLI interface to control Santa's Submarine.
           |Submarine is used to solve the Advent of Code 2021 problems.
           |""".stripMargin)

  addSubcommand(new PuzzleSubcommand(aocDefaults))
  addSubcommand(new SubmarineSubcommand(aocDefaults))
  verify()

  def selection: ExecutionSelection = subcommand match {
    case Some(puzzleSubcommand: PuzzleSubcommand) => puzzleSubcommand.selection
    case Some(submarineSubcommand: SubmarineSubcommand) => submarineSubcommand.selection
    case _ => Unknown
  }
}
