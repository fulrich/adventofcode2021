package com.fulrich.aoc.submarine.window.crabs

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class AligntmentCostTest extends AnyFunSuite:
  test("Can determine the fuel cost for a set movement") {
    AlignmentCost.fuelRequired(1) shouldBe 1
    AlignmentCost.fuelRequired(2) shouldBe 3
    AlignmentCost.fuelRequired(3) shouldBe 6
    AlignmentCost.fuelRequired(4) shouldBe 10
  }