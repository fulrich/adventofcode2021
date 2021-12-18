package com.fulrich.aoc.submarine.sensors.probes

import com.fulrich.aoc.algebra.Coordinate

case class TargetArea(minimum: Coordinate, maximum: Coordinate):
  def within(coordinate: Coordinate): Boolean =
    coordinate.x >= minimum.x &&
    coordinate.y >= minimum.y &&
    coordinate.x <= maximum.x &&
    coordinate.y <= maximum.y
  
  def past(coordinate: Coordinate): Boolean = coordinate.x > maximum.x || coordinate.y < minimum.y

object TargetArea:
  val none: TargetArea = TargetArea(Coordinate.origin, Coordinate.origin)
  
  def apply(xRange: (Int, Int), yRange: (Int, Int)): TargetArea =
    TargetArea(
      Coordinate(Math.min(xRange._1, xRange._2), Math.min(yRange._1, yRange._2)),
      Coordinate(Math.max(xRange._1, xRange._2), Math.max(yRange._1, yRange._2))
    )
