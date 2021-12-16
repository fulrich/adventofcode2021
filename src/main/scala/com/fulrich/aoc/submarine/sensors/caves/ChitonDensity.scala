package com.fulrich.aoc.submarine.sensors.caves

import com.fulrich.aoc.algebra._
import scala.annotation.tailrec

case class ChitonDensity(chitons: Grid[Int]):
  lazy val start = Coordinate.origin
  lazy val end = Coordinate(chitons.maximumColumn, chitons.maximumRow)

  def increaseGrid(increase: Int = 5): ChitonDensity = {
    val increasedChitons = (0 until increase).map { downMovement =>
      val gridAtStart = chitons.moveDown(downMovement * chitons.height).mapValues(increaseChitons(downMovement))
      (0 until increase).map { rightMovement =>
        gridAtStart.moveRight(rightMovement * chitons.width).mapValues(increaseChitons(rightMovement))
      }.reduce(_.merge(_))
    }.reduce(_.merge(_))

    copy(chitons = increasedChitons)
  }

  def increaseChitons(movement: Int)(original: Int) = {
    (1 to movement).foldLeft(original) { case(accumulator, _) => 
      val newValue = accumulator + 1
      if newValue > 9 then 1 else newValue
    }
  }
    
  lazy val lowestRisk: Int = lowestRisk(PathTracking(chitons)).costAt(end)

  @tailrec
  final def lowestRisk(tracking: PathTracking): PathTracking = {
    if (tracking.isDone) then tracking
    else lowestRisk(
      tracking.currentAdjacent.foldLeft(tracking) { case(updatedTracking, coordinate) =>
        val costToCoordinate = tracking.costAtCurrent + chitons(coordinate)
        if updatedTracking.costAt(coordinate) > costToCoordinate then 
          updatedTracking.updateCosts(coordinate, costToCoordinate) 
        else 
          updatedTracking
      }.next
    )
  }

object ChitonDensity:
  def parse(input: Seq[String]): ChitonDensity = ChitonDensity(
    Grid.parse(input)((coordinate, value) => value.asDigit)
  )
