package com.fulrich.aoc.submarine.window.crabs


import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class SwarmTest extends AnyFunSuite:
  val crabs = Seq(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)
  val swarm = Swarm(crabs)

  test("Can determine the cheapest alignment cost") {
    swarm.cheapestAlignment shouldBe AlignmentCost(position = 5, fuel  = 168)
  }

  test("Can determine the cost of the swam to align at a specific position") {
    swarm.costAt(1).fuel shouldBe 242
    swarm.costAt(2).fuel shouldBe 206
    swarm.costAt(3).fuel shouldBe 183
    swarm.costAt(10).fuel shouldBe 311
  }

  test("Can parse a swarm from a string") {
    Swarm.parse("16,1,2,0,4,2,7,1,2,14") shouldBe swarm
  }