package com.fulrich.aoc.submarine.sensors.probes

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

import com.fulrich.aoc.algebra.Coordinate

class ProbeTest extends AnyFunSuite:
  val target = TargetArea(xRange = (20, 30), yRange = (-10, 5))

  test("Can follow along a probes path until a hit") {
    val probe = Probe.from(Coordinate.origin).aim(at = target).power(Velocity(7, 2))

    probe.isComplete shouldBe false
    probe.hitArea shouldBe false
    probe.missedArea shouldBe false

    val hit = probe.next.next.next.next.next.next.next
    hit.isComplete shouldBe true
    hit.hitArea shouldBe true
    hit.missedArea shouldBe false
  }

  test("Can fire and detect when the probe hits the area") {
    val first = Probe.fromOrigin.aim(at = target).fire(Velocity(7, 2))
    first.isComplete shouldBe true
    first.hitArea shouldBe true
    first.apex shouldBe 3
    first.velocity shouldBe Velocity(7, 2)

    val second = Probe.fromOrigin.aim(at = target).fire(Velocity(6, 3))
    second.isComplete shouldBe true
    second.hitArea shouldBe true
    second.apex shouldBe 6
    second.velocity shouldBe Velocity(6, 3)

    val third = Probe.fromOrigin.aim(at = target).fire(Velocity(9, 0))
    third.isComplete shouldBe true
    third.hitArea shouldBe true
    third.apex shouldBe 0
    third.velocity shouldBe Velocity(9, 0)
  }

  test("Can fire and detect when the probe misses the area") {
    val missed = Probe.fromOrigin.aim(at = target).fire(Velocity(17, -4))
    missed.isComplete shouldBe true
    missed.hitArea shouldBe false
    missed.missedArea shouldBe true
  }
