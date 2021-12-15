package com.fulrich.aoc.submarine.sensors.thermals

sealed trait FoldInstruction
case class Horzontal(row: Int) extends FoldInstruction
case class Vertical(column: Int) extends FoldInstruction

object FoldInstruction:
  val Prefix = "fold along "

  def parse(inputs: Seq[String]): Seq[FoldInstruction] = inputs.map(parse)
  
  def parse(input: String): FoldInstruction = input.drop(Prefix.length).split("=") match {
    case Array("x", column) => Vertical(column.toInt)
    case Array("y", row) => Horzontal(row.toInt)
  }
