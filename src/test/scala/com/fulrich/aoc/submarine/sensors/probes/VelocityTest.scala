package com.fulrich.aoc.submarine.sensors.probes

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class VelocityTest extends AnyFunSuite:
  test("Can apply drag to a Velocity with a positive x")  {
    val velocity = Velocity(5, 5)

    velocity.drag.x shouldBe 4
    velocity.drag.y shouldBe 4
  }

  test("Can apply drag to a Velocity with a negative x")  {
    val velocity = Velocity(-5, 5)

    velocity.drag.x shouldBe -4
    velocity.drag.y shouldBe 4
  }

  test("Can apply drag to velocities with 0") {
    val velocity = Velocity(0, 0)

    velocity.drag.x shouldBe 0
    velocity.drag.y shouldBe -1
  }
