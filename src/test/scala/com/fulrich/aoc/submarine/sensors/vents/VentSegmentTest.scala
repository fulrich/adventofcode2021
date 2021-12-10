package com.fulrich.aoc.submarine.sensors.vents

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.submarine.sensors.Coordinate

class VentSegmentTest extends AnyFunSuite with LoneElement:
  test("Can create a vent segment from a string") {
    VentSegment("1,2 -> 5,0") shouldBe VentSegment(Coordinate(1, 2), Coordinate(5, 0))
    VentSegment("1,2->5,0") shouldBe VentSegment(Coordinate(1, 2), Coordinate(5, 0))
    VentSegment(" 1 , 2 -> 5 , 0 ") shouldBe VentSegment(Coordinate(1, 2), Coordinate(5, 0))
  }

  test("Cannot create a sequence for an invalid angle") {
    val segment = VentSegment(Coordinate(9, 7), Coordinate(5, 5))
    segment.points shouldBe empty
  }

  test("Can create diagonal sequences") {
    val segment = VentSegment(Coordinate(9, 7), Coordinate(7, 9))
    val expected = Seq(Coordinate(9, 7), Coordinate(8, 8), Coordinate(7, 9))

    segment.points shouldBe expected
  }

  test("Can create diagonal sequences in another direction") {
    val segment = VentSegment(Coordinate(1, 1), Coordinate(3, 3))
    val expected = Seq(Coordinate(1, 1), Coordinate(2, 2), Coordinate(3, 3))

    segment.points shouldBe expected
  }
  
  test("Returns a list of one coordinate of the two coordinates are equal") {
    val segment = VentSegment(Coordinate(5, 5), Coordinate(5, 5))

    segment.points.loneElement shouldBe Coordinate(5, 5)
  }

  test("Creates a list of horizontal coordinates if the x coords are equal") {
    val segment = VentSegment(Coordinate(1, 2), Coordinate(1, 4))
    val expectedPoints = Seq(
      Coordinate(1, 2),
      Coordinate(1, 3),
      Coordinate(1, 4)
    )

    segment.points shouldBe expectedPoints
  }

  test("Creates a list of vertical coordinates if the y coords are equal") {
    val segment = VentSegment(Coordinate(1, 2), Coordinate(4, 2))
    val expectedPoints = Seq(
      Coordinate(1, 2),
      Coordinate(2, 2),
      Coordinate(3, 2),
      Coordinate(4, 2)
    )

    segment.points shouldBe expectedPoints
  }