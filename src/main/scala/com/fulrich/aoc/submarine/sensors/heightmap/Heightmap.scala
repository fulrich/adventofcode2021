package com.fulrich.aoc.submarine.sensors.heightmap

import com.fulrich.aoc.submarine.sensors.Coordinate

case class Heightmap(private val full: Map[Coordinate, Height]):
  def at(coordinate: Coordinate): Option[Height] = full.get(coordinate)
  def at(x: Int, y: Int): Option[Height] = at(Coordinate(x, y))

  lazy val heights: Seq[Height] = full.values.toSeq
  lazy val lowHeights: Seq[Height] = heights.filter(isLow)
  lazy val lowPointsRisk: Int = lowHeights.map(_.height).map(_ + 1).sum

  lazy val basins: Seq[Basin] = lowHeights.map(Basin.fromLow(_, this))

  def areaOfLargestBasins(numberOfBasins: Int): Int = basins
    .sorted
    .takeRight(numberOfBasins)
    .foldLeft(1) { case (total, basin) => total * basin.size }

  private def isLow(coordinate: Height): Boolean = coordinate.at.adjacent
    .flatMap(at)
    .map(_.height > coordinate.height)
    .reduce(_ && _)

object Heightmap:
  def parse(input: Seq[String]): Heightmap = Heightmap(
    input.zipWithIndex.flatMap { (row, y) =>
      row.toSeq.zipWithIndex.map { (height, x) =>
        Coordinate(x, y) -> Height(Coordinate(x, y), height.asDigit)
      }
    }.toMap
  )
