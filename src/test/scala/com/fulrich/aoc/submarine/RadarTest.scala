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

  test("Can count the numbef of increasing window values in the real file") {
    val depths = PuzzleInput.fromResource("day_1")

    Radar.increasingDepthWindows(depths) shouldBe 1497
  }

  test("Can count the numbef of increasing window values in the test data") {
    Radar.increasingDepthWindows(testData) shouldBe 5
  }

  test("Can count the number of increasing values in the real file") {
    val depths = PuzzleInput.fromResource("day_1")

    Radar.increasingDepths(depths) shouldBe 1462
  }

  test("Can count the number of increasing values in the test data") {
    Radar.increasingDepths(testData) shouldBe 7
  }

  test("Can count the number of increasing values in a sequence of depths") {
    val depths = PuzzleInput("200", "210", "190", "208")

    Radar.increasingDepths(depths) shouldBe 2
  }