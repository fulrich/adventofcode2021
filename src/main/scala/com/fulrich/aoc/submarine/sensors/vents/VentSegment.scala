package com.fulrich.aoc.submarine.sensors.vents

import com.fulrich.aoc.submarine.sensors.Coordinate

case class VentSegment(start: Coordinate, end: Coordinate):
  lazy val points: Seq[Coordinate] = if validAngle then build else Seq.empty

  lazy val validAngle: Boolean = (xDistance == 0 || yDistance == 0) || (xDistance == yDistance)

  lazy val distance = Math.max(xDistance, yDistance) + 1
  lazy val xDistance = Math.abs(start.x - end.x)
  lazy val yDistance = Math.abs(start.y - end.y)

  private def build: Seq[Coordinate] = {
    val xSlope = Integer.compare(end.x, start.x)
    val ySlope = Integer.compare(end.y, start.y)

    Seq.tabulate(distance) { index => 
      Coordinate(start.x + (index * xSlope), start.y + (index * ySlope)) 
    }
  }

object VentSegment:
  def apply(input: String): VentSegment = input.split("->") match {
    case Array(start: String, end: String) => VentSegment(Coordinate(start), Coordinate(end))
    case _ => throw IllegalArgumentException(s"Cannot build a VentSegment from $input")
  }
