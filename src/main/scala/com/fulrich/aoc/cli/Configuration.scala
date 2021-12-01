package com.fulrich.aoc.cli

import org.rogach.scallop._
import com.fulrich.aoc.input._
import java.io.File
import org.rogach.scallop.exceptions.ScallopException

class Configuration(arguments: Seq[String]) extends ScallopConf(arguments) {
  printedName = "AoC2021"
  banner("""Advent of Code 2021 - Scala 3
           |Solves the Advent of Code 2021 problems.
           |""".stripMargin)

  val problemSelection = group("Problem Selection:")
  val day = opt[Int](
    group = problemSelection,
    descr = "Choose which day to solve.",
  )
  val part = opt[Int](
    group = problemSelection,
    descr = "Choose which part of the day to solve.",
    default = Some(1),
    validate = value => value == 1 || value == 2
  )

  val problemInput = group("Problem Input:")
  val resource = opt[String](
    group = problemInput,
    descr = "Supply puzzle input as one of the resources.",
  )
  val file = opt[File](
    group = problemInput,
    descr = "Supply puzzle input from a file path."
  )
  
  mutuallyExclusive(resource, file)
  validateFileExists(file)
  verify()

  def puzzleSelection: PuzzleSelection = PuzzleSelection(day.toOption, part.toOption)

  def inputRequest: InputRequest = {
    if(resource.isDefined) then return ResourceRequest(resource())
    if(file.isDefined) then return FileRequest(file())

    ResourceRequest("default")
  }
}
