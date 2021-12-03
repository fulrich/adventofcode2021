package com.fulrich.aoc.submarine.diagnostics

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input.PuzzleInput

class DiagnosticBitTest extends AnyFunSuite:
  val diagnosticBit = DiagnosticBit.empty

  test("The gamma bit is determined by the most common bit") {
    DiagnosticBit(oneCount = 4, zeroCount = 6).gammaBit shouldBe '0'
    DiagnosticBit(oneCount = 8, zeroCount = 2).gammaBit shouldBe '1'
  }

  test("The epsilon bit is determined by the least common bit") {
    DiagnosticBit(oneCount = 4, zeroCount = 6).epsilonBit shouldBe '1'
    DiagnosticBit(oneCount = 8, zeroCount = 2).epsilonBit shouldBe '0'
  }

  test("If the counts are equal the gamma bit is 1") {
    DiagnosticBit(oneCount = 5, zeroCount = 5).gammaBit shouldBe '1'
  }

  test("If the counts are equal the epsilon bit is 0") {
    DiagnosticBit(oneCount = 5, zeroCount = 5).epsilonBit shouldBe '0'
  }

  test("Increments the oneCount if the char is a 1") {
    val result = diagnosticBit.track('1')

    result.oneCount shouldBe 1
    result.zeroCount shouldBe 0
  }

  test("Increments the zeroCount if the char is a 0") {
    val result = diagnosticBit.track('0')

    result.oneCount shouldBe 0
    result.zeroCount shouldBe 1
  }