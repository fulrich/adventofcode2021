package com.fulrich.aoc.submarine.window.crabs

case class Swarm(crabs: Seq[Int]):
  lazy val minimum: Int = crabs.min
  lazy val maximum: Int = crabs.max

  lazy val cheapestAlignment: AlignmentCost = alignmentCosts.minBy(_.fuel)
  lazy val alignmentCosts: Seq[AlignmentCost] = Seq.tabulate(maximum - minimum) { position => costAt(minimum + position) }

  def costAt(position: Int): AlignmentCost = 
    crabs.foldLeft(AlignmentCost.at(position)) {  case (cost, crabPosition) => cost + Math.abs(position - crabPosition) }

object Swarm:
  def parse(swarm: String): Swarm = Swarm(swarm.split(",").map(_.toInt))
