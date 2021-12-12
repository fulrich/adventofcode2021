package com.fulrich.aoc.submarine.window.octopuses

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class ConsortiumTest extends AnyFunSuite:
  val complex = Consortium.parse(Seq(
    "5483143223",
    "2745854711",
    "5264556173",
    "6141336146",
    "6357385478",
    "4167524645",
    "2176841721",
    "6882881134",
    "4846848554",
    "5283751526"
  ))

  test("Can detect the initial flashes") {
    val simple = Consortium.parse(Seq(
      "11111",
      "19991",
      "19191",
      "19991",
      "11111"
    ))

    simple.observe.flashes shouldBe 9
  }

  test("Can observe over multiple cycles") {
    complex.observeOver(10).flashes shouldBe 204
    complex.observeOver(100).flashes shouldBe 1656
  }

  test("Can determine the step they all syncronize") {
    complex.synchronizationStep() shouldBe 195
  }
