package com.fulrich.aoc.submarine.sensors.heightmap

import scala.annotation.tailrec
import com.fulrich.aoc.algebra.Grid

case class Basin(low: Height, points: Seq[Height]):
  lazy val size: Int = points.size
  def ++(additionalPoints: Seq[Height]): Basin = copy(points = (points ++ additionalPoints).distinct)

object Basin:
  def fromLow(low: Height, heightMap: Grid[Height]): Basin =  build(Seq(low), Basin(low, Seq.empty), heightMap)
    
  @tailrec
  def build(confirmed: Seq[Height], basin: Basin, heightMap: Grid[Height]): Basin = {
    val increasedBasin = basin ++ confirmed
    val confirmedAdjacents = confirmed.flatMap { point =>
      point.at.adjacent.flatMap(heightMap.at).filter { adjacentPoint =>
        adjacentPoint.height > point.height && adjacentPoint.height < 9
      }
    }.distinct

    if confirmedAdjacents.isEmpty then increasedBasin else build(confirmedAdjacents, increasedBasin, heightMap)
  }

  given Ordering[Basin] with
    override def compare(x: Basin, y: Basin): Int = x.size.compareTo(y.size)
