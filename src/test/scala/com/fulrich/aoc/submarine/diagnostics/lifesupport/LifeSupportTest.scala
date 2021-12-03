package com.fulrich.aoc.submarine.diagnostics.lifesupport

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input.PuzzleInput
import com.fulrich.aoc.submarine.diagnostics.DiagnosticData

class LifeSupportTest extends AnyFunSuite:
  val input = Seq(
    "00100",
    "11110",
    "10110",
    "10111",
    "10101",
    "01111",
    "00111",
    "11100",
    "10000",
    "11001",
    "00010",
    "01010"
  )

  test("Can determine the Life Support Rating") {
    LifeSupport(DiagnosticData.from(input)).rating shouldBe 230
  }
  
  test("Can determine the Oxygen Generator Rating") {
    LifeSupport(DiagnosticData.from(input)).oxygenGeneratorRating shouldBe 23
  }

  test("Can determine the CO2 Scrubber Rating") {
    LifeSupport(DiagnosticData.from(input)).coScrubberRating shouldBe 10
  }