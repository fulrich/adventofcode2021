package com.fulrich.aoc.submarine.window.octopuses

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.algebra.Coordinate

class OctopusTest extends AnyFunSuite:
  test("When energizing an octopus increases its energy level") {
    val lowEnergy = Storing(Coordinate.origin, 0, 0).energize 
    lowEnergy.hasFlashed shouldBe false
    lowEnergy.justFlashed shouldBe false
    lowEnergy.energy shouldBe 1

    val highEnergy = Storing(Coordinate.origin, 8, 0).energize 
    highEnergy.hasFlashed shouldBe false
    highEnergy.justFlashed shouldBe false
    highEnergy.energy shouldBe 9
  }

  test("When energizing tracks a flash if the energy levels surpasses the flash point") {
    val flashedOctopus = Storing(Coordinate.origin, 9, 0).energize

    flashedOctopus.hasFlashed shouldBe true
    flashedOctopus.justFlashed shouldBe true
    flashedOctopus.energy shouldBe 10
    flashedOctopus.flashes shouldBe 1
  }

  test("Completing the flash moves a JustFlashes Octopus to Flashed and does nothing otherwise") {
    JustFlashed(Coordinate.origin, 10, 1).completeFlash shouldBe Flashed(Coordinate.origin, 10, 1)
    Storing(Coordinate.origin, 8, 3).completeFlash shouldBe Storing(Coordinate.origin, 8, 3)
    Flashed(Coordinate.origin, 12, 4).completeFlash shouldBe Flashed(Coordinate.origin, 12, 4)
  }

  test("Resetting a flash moves a Flashed back to Stroing and does nothing otherwise") {
    Storing(Coordinate.origin, 8, 3).resetFlash shouldBe Storing(Coordinate.origin, 8, 3)
    JustFlashed(Coordinate.origin, 10, 1).resetFlash shouldBe JustFlashed(Coordinate.origin, 10, 1)
    Flashed(Coordinate.origin, 12, 4).resetFlash shouldBe Storing(Coordinate.origin, 0, 4)
  }
