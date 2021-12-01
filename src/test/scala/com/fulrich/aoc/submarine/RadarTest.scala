package com.fulrich.aoc.submarine

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input.PuzzleInput

class RadarTest extends AnyFunSuite:
  val testData = PuzzleInput(
    "199",
    "200",
    "208",
    "210",
    "200",
    "207",
    "240",
    "269",
    "260",
    "263"
  )

  test("Day 1 - Part 1: Solution") {
    val depths = PuzzleInput.fromResource("day_1")

    Radar.countIncreasingDepths(depths) shouldBe 1462
  }

  test("Day 1 - Part 2: Soution") {
    val depths = PuzzleInput.fromResource("day_1")

    Radar.countIncreasingDepths(depths, windowSize = 3) shouldBe 1497
  }

  test("Can count the numbef of increasing depths for a different window size") {
    Radar.countIncreasingDepths(testData, windowSize = 3) shouldBe 5
  }

  test("Can count the number of increasing values for the default window size") {
    Radar.countIncreasingDepths(testData) shouldBe 7
  }