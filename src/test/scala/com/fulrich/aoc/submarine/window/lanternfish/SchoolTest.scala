package com.fulrich.aoc.submarine.window.lanternfish

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class AocDefaultsTest extends AnyFunSuite:
  val initialFish = Seq[Long](3, 4, 3, 1, 2)

  test("Can load the initial school of fish from a seq of integers") {
    val school = School(initialFish)
    val expectedReproducingFish = Seq(1, 1, 2, 1, 0, 0, 0)
    val expectedMaturingFish = Seq(0, 0)

    school.reproducingFish shouldBe expectedReproducingFish
    school.maturingFish shouldBe expectedMaturingFish
    school.totalFish shouldBe 5
  }

  test("Can observe the lifecycle of fish over many days") {
    val school = School(initialFish)

    school.observeOver(days = 18).totalFish shouldBe 26
  }

  test("Can observe the lifecycle of fish over a lot of days") {
    val school = School(initialFish)

    school.observeOver(days = 80).totalFish shouldBe 5934
  }