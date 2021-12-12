package com.fulrich.aoc.submarine.sensors.heightmap

import com.fulrich.aoc.algebra.{Grid, Coordinate}

case class Heightmap(private val full: Grid[Height]):
  lazy val heights: Seq[Height] = full.values.toSeq
  lazy val lowHeights: Seq[Height] = heights.filter(isLow)
  lazy val lowPointsRisk: Int = lowHeights.map(_.height).map(_ + 1).sum

  lazy val basins: Seq[Basin] = lowHeights.map(Basin.fromLow(_, full))

  def areaOfLargestBasins(numberOfBasins: Int): Int = basins
    .sorted
    .takeRight(numberOfBasins)
    .foldLeft(1) { case (total, basin) => total * basin.size }

  private def isLow(coordinate: Height): Boolean = coordinate.at.adjacent
    .flatMap(full.at)
    .map(_.height > coordinate.height)
    .reduce(_ && _)

object Heightmap:
  def parse(input: Seq[String]): Heightmap = Heightmap(
    Grid.parse(input) { case (coordinate, value) => Height(coordinate, value.asDigit) }
  )
