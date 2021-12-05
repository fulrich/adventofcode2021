package com.fulrich.aoc.submarine.sensors.vents

case class Coordinate(x: Int, y: Int)

object Coordinate:
  def apply(input: String): Coordinate = input.split(",") match {
    case Array(x: String, y: String) => Coordinate(x.trim.toInt, y.trim.toInt)
    case _ => throw IllegalArgumentException(s"Cannot build a Coordinate from $input")
  }