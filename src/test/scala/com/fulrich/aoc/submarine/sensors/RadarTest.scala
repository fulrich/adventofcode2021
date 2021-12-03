package com.fulrich.aoc.submarine.sensors

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class RadarTest extends AnyFunSuite:
  val radar = new Radar
  val testData = Seq(
    199,
    200,
    208,
    210,
    200,
    207,
    240,
    269,
    260,
    263
  )

  test("Can count the numbef of increasing depths for a different window size") {
    radar.depthScan(testData, windowSize = 3) shouldBe 5
  }

  test("Can count the number of increasing values for the default window size") {
    radar.depthScan(testData) shouldBe 7
  }
