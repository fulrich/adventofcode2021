package com.fulrich.aoc.submarine.sensors.vents

import scala.annotation.targetName

case class Vent(segments: Seq[VentSegment]):
  def intersectionsOver(minimum: Int): Seq[Coordinate] =
    intersections.filter(_._2 >= minimum).keys.toSeq

  lazy val points = segments.flatMap(_.points)
  lazy val intersections = points.groupMapReduce(identity)(_ => 1)(Integer.sum)

object Vent:
  @targetName("applyStringSeq")
  def apply(input: Seq[String]): Vent = Vent(input.map(VentSegment.apply))