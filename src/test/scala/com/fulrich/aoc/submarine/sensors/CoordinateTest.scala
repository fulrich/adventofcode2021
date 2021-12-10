package com.fulrich.aoc.submarine.sensors

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class CoordinateTest extends AnyFunSuite:
  test("Can use a String to create a Coordinate"){
    Coordinate("1,2") shouldBe Coordinate(1, 2)
    Coordinate("1, 2") shouldBe Coordinate(1, 2)
    Coordinate("  1, 2 ") shouldBe Coordinate(1, 2)
  }
