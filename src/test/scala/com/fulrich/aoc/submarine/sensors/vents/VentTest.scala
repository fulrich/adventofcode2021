package com.fulrich.aoc.submarine.sensors.vents

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.submarine.sensors.Coordinate

class VentTest extends AnyFunSuite:
  test("Can create a vent from a list of strings") {
    val vent = Vent(Seq(
      "0,9 -> 5,9",
      "8,0 -> 0,8"
    ))

    val expectedVent = Vent(Seq(
      VentSegment(Coordinate(0, 9), Coordinate(5, 9)),
      VentSegment(Coordinate(8, 0), Coordinate(0, 8))
    ))
  }

  test("Can get the list of points from all segments") {
    val segment1 = VentSegment(Coordinate(0, 0), Coordinate(0, 4))
    val segment2 = VentSegment(Coordinate(4, 4), Coordinate(0, 4))
    val vent = Vent(Seq(segment1, segment2))

    vent.points shouldBe (segment1.points ++ segment2.points)
  }

  test("Can determine the intersection frequency") {
    val vent = Vent(Seq(
      "0,9 -> 5,9",
      "0,9 -> 2,9",
    ))

    val expected = Map(
      Coordinate(0, 9) -> 2,
      Coordinate(1, 9) -> 2,
      Coordinate(2, 9) -> 2,
      Coordinate(3, 9) -> 1,
      Coordinate(4, 9) -> 1,
      Coordinate(5, 9) -> 1
    )

    vent.intersections shouldBe expected
  }

  test("Can count the number of coordinates with an intersection over a certain number") {
    val vent = Vent(Seq(
      "0,9 -> 5,9",
      "8,0 -> 0,8",
      "9,4 -> 3,4",
      "2,2 -> 2,1",
      "7,0 -> 7,4",
      "6,4 -> 2,0",
      "0,9 -> 2,9",
      "3,4 -> 1,4",
      "0,0 -> 8,8",
      "5,5 -> 8,2"
    ))

    vent.intersectionsOver(2).length shouldBe 12
  }
