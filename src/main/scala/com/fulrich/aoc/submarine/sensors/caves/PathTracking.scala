package com.fulrich.aoc.submarine.sensors.caves

import com.fulrich.aoc.algebra._

case class PathTracking(costs: Grid[Int], priorityQueue: Seq[ChitonRisk]):
  lazy val isDone: Boolean = priorityQueue.isEmpty
  lazy val current: ChitonRisk = priorityQueue.head

  lazy val costAtCurrent: Int = costAt(current.at)
  lazy val currentAdjacent: Seq[Coordinate] = current.at.adjacent.filter(costs.contains)

  def next: PathTracking = copy(priorityQueue = priorityQueue.tail)

  def updateCosts(coordinate: Coordinate, cost: Int): PathTracking = updateCosts(ChitonRisk(cost, coordinate))
  def updateCosts(risk: ChitonRisk): PathTracking = copy(
    costs = costs.updated(risk.at, risk.level), 
    (priorityQueue :+ risk).sortBy(_.level)
  )

  def costAt(coordinate: Coordinate): Int = costs.at(coordinate).getOrElse(Integer.MAX_VALUE)

object PathTracking:
  def apply(original: Grid[Int]): PathTracking =
    PathTracking(
      original.mapValues(_ => Integer.MAX_VALUE).updated(Coordinate.origin, 0),
      Seq(ChitonRisk(0, Coordinate.origin))
    )
