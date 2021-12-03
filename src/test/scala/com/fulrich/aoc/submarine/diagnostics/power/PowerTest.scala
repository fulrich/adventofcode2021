package com.fulrich.aoc.submarine.diagnostics.power

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input.PuzzleInput
import com.fulrich.aoc.submarine.diagnostics.DiagnosticData

class PowerConsumptionTest extends AnyFunSuite:
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

  test("Can determine the power consumption of the submarine") {
    Power(DiagnosticData.from(input)).consumption shouldBe 198
  }

  test("Can determine the gamma rate based on the gamme bit") {
    Power(DiagnosticData.from(input)).gammaRate shouldBe 22
  }

  test("Can determine the epsilon rate based on the gamme bit") {
    Power(DiagnosticData.from(input)).epsilonRate shouldBe 9
  }