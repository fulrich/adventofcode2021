package com.fulrich.aoc.submarine.sensors.probes

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

import com.fulrich.aoc.algebra.Coordinate

class LauncherTest extends AnyFunSuite:
  test("Can find probe with the highest apex") {
    val targetArea = TargetArea(xRange = (20, 30), yRange = (-10, -5))
    Launcher.probeWithHighestApex(targetArea).apex shouldBe 45
  }

  test("Can find the number of possible trajectories") {
    val targetArea = TargetArea(xRange = (20, 30), yRange = (-10, -5))
    Launcher.totalPossibleVelocities(targetArea) shouldBe 112
  }
