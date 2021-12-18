package com.fulrich.aoc.submarine.sensors.probes

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

import com.fulrich.aoc.algebra.Coordinate

class TargetAreaTest extends AnyFunSuite:
  val target = TargetArea(xRange = (20, 30), yRange = (-10, -5))

  test("Can determine if points are within the target area") {
    target.within(Coordinate(20, -6)) shouldBe true
    target.within(Coordinate(30, -6)) shouldBe true
    target.within(Coordinate(25, -10)) shouldBe true
    target.within(Coordinate(25, -5)) shouldBe true
  }

  test("Can determine if points are not within the target area") {
    target.within(Coordinate(19, -6)) shouldBe false
    target.within(Coordinate(31, -6)) shouldBe false
    target.within(Coordinate(25, -11)) shouldBe false
    target.within(Coordinate(25, -4)) shouldBe false
  }

  test("Can determine if the coordinate is past the target area") {
    target.past(Coordinate.origin) shouldBe false
    target.past(Coordinate(23, 8)) shouldBe false
    target.past(Coordinate(31, 8)) shouldBe true
    target.past(Coordinate(23, -11)) shouldBe true
  }
