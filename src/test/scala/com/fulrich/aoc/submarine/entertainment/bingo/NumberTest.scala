package com.fulrich.aoc.submarine.entertainment.bingo

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class NumberTest extends AnyFunSuite:
  test("Can change an unmarked number to a marked number") {
    val unmarked = Number(20, Location(1, 1))

    unmarked.number shouldBe 20
    unmarked.marked shouldBe false

    val marked = unmarked.mark

    marked.number shouldBe 20
    marked.marked shouldBe true
  }

  test("Can mark only if a given number matches the drawn number") {
    val number = Number(10, Location(2, 1))

    number.markIf(20).marked shouldBe false
    number.markIf(10).marked shouldBe true
  }

  test ("Can determine if a number is at a given location") {
    val number = Number(10, Location(2, 1))

    number.isAt(Location(1, 1)) shouldBe false
    number.isAt(Location(2, 1)) shouldBe true
  }
