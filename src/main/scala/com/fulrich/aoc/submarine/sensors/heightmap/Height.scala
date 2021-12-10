package com.fulrich.aoc.submarine.sensors.heightmap

import com.fulrich.aoc.submarine.sensors.Coordinate

case class  Height(at: Coordinate, height: Int)

object Height:
  def apply(x: Int, y: Int, height: Int): Height = Height(Coordinate(x, y), height)
