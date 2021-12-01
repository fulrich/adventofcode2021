package com.fulrich.aoc.input

import scala.io.Source
import scala.annotation.targetName
import java.io.File
import java.nio.file.{Files, Paths}
import scala.collection.JavaConverters._

case class PuzzleInput(raw: Seq[String]):
  def toInt: Seq[Int] = raw.map(_.toInt)

object PuzzleInput:
  @targetName("variable")
  def apply(rawStrings: String*): PuzzleInput = PuzzleInput(rawStrings)

  def fromResource(name: String): PuzzleInput =
    PuzzleInput(Source.fromResource(name).getLines.toVector)

  def fromFile(file: File): PuzzleInput =
    PuzzleInput(Files.lines(Paths.get(file.getPath)).iterator.asScala.toVector)
  
  def fromInputRequest(inputRequest: InputRequest): PuzzleInput = inputRequest match {
    case ResourceRequest(name) => fromResource(name)
    case FileRequest(file) =>  fromFile(file)
  }
