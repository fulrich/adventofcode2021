package com.fulrich.aoc.submarine.diagnostics

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input.PuzzleInput

class DiagnosticTest extends AnyFunSuite:
  val diagnostics = Diagnostics()
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
