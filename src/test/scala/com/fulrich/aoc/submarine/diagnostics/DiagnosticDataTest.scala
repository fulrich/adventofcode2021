package com.fulrich.aoc.submarine.diagnostics

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input.PuzzleInput

class DiagnosticDataTest extends AnyFunSuite:
  test("Can track the diagnostics for a set of binary values") {
    val expected = Seq(DiagnosticBit(oneCount = 2), DiagnosticBit(oneCount = 1, zeroCount = 1))

    DiagnosticData.empty.track("10").track("11").bits shouldBe expected
  }

  test("Can handle different sizes of input diagnosics") {
    val expected = Seq(DiagnosticBit(oneCount = 3), DiagnosticBit(oneCount = 2, zeroCount = 1), DiagnosticBit(oneCount = 1))

    DiagnosticData.empty.track("10").track("11").track("111").bits shouldBe expected
  }
