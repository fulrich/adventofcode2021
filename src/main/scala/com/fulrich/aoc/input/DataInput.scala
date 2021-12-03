package com.fulrich.aoc.input

import scala.io.Source
import scala.annotation.targetName
import java.io.File
import java.nio.file.{Files, Paths}
import scala.collection.JavaConverters._

case class DataInput(raw: Seq[String])

object DataInput:
  @targetName("variable")
  def apply(rawStrings: String*): DataInput = DataInput(rawStrings)

  def apply(inputRequest: InputRequest): DataInput = inputRequest match {
    case ResourceRequest(name) => fromResource(name)
    case FileRequest(file) =>  fromFile(file)
  }

  def fromResource(name: String): DataInput =
    DataInput(Source.fromResource(name).getLines.toVector)

  def fromFile(file: File): DataInput =
    DataInput(Files.lines(Paths.get(file.getPath)).iterator.asScala.toVector)
