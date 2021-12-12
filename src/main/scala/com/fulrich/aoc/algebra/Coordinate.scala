package com.fulrich.aoc.algebra

case class Coordinate(x: Int, y: Int):
  lazy val up: Coordinate = copy(y = y - 1)
  lazy val down: Coordinate = copy(y = y + 1)
  lazy val left: Coordinate = copy(x = x - 1)
  lazy val right: Coordinate = copy(x = x + 1)

  lazy val upLeft: Coordinate = up.left
  lazy val upRight: Coordinate = up.right
  lazy val downLeft: Coordinate = down.left
  lazy val downRight: Coordinate = down.right

  lazy val adjacent: Seq[Coordinate] = Seq(up, down, left, right)
  lazy val diagonal: Seq[Coordinate] = Seq(upLeft, upRight, downLeft, downRight)

  lazy val surrounding: Seq[Coordinate]  = adjacent ++ diagonal

object Coordinate:
  val origin: Coordinate = Coordinate(0, 0)
  
  def apply(input: String): Coordinate = input.split(",") match {
    case Array(x: String, y: String) => Coordinate(x.trim.toInt, y.trim.toInt)
    case _ => throw IllegalArgumentException(s"Cannot build a Coordinate from $input")
  }
