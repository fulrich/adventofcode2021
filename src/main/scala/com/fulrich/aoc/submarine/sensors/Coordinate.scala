package com.fulrich.aoc.submarine.sensors

case class Coordinate(x: Int, y: Int):
  lazy val up: Coordinate = copy(y = y - 1)
  lazy val down: Coordinate = copy(y = y + 1)
  lazy val left: Coordinate = copy(x = x - 1)
  lazy val right: Coordinate = copy(x = x + 1)

  lazy val adjacent: Seq[Coordinate] = Seq(up, down, left, right)

object Coordinate:
  def apply(input: String): Coordinate = input.split(",") match {
    case Array(x: String, y: String) => Coordinate(x.trim.toInt, y.trim.toInt)
    case _ => throw IllegalArgumentException(s"Cannot build a Coordinate from $input")
  }