package com.fulrich.aoc.input

import scala.io.Source
import scala.annotation.targetName
import com.fulrich.aoc.CommandLineConfig

case class PuzzleInput(raw: Seq[String]):
  def toInt: Seq[Int] = raw.map(_.toInt)

object PuzzleInput:
  @targetName("variable")
  def apply(rawStrings: String*): PuzzleInput = PuzzleInput(rawStrings)

  def fromResource(name: String): PuzzleInput =
    PuzzleInput(Source.fromResource(name).getLines.toVector)
  
  def fromConfiguration(configuration: CommandLineConfig): PuzzleInput =
    fromResource(configuration.resource())