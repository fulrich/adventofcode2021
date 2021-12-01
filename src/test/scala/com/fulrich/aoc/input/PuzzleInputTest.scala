package com.fulrich.aoc.input

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class PuzzleInputTest extends AnyFunSuite:
  test("Can create a puzzle input from a list of strings") {
    val rawStrings = Vector("1", "2", "3")

    PuzzleInput(rawStrings).raw shouldBe rawStrings
  }

  test("Can create a puzzle input from a variable list of strings") {
    PuzzleInput("1", "2", "3").raw shouldBe Vector("1", "2", "3")
  }