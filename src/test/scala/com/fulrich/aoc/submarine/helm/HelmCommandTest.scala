package com.fulrich.aoc.submarine.helm

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input.PuzzleInput

class HelmCommandTest extends AnyFunSuite:
  test("Can parse a forward command")  {
    HelmCommand.parse("forward 5")  shouldBe Forward(5)
  }

  test("Can parse an up command")  {
    HelmCommand.parse("up 8")  shouldBe Up(8)
  }

  test("Can parse a down command")  {
    HelmCommand.parse("down 12")  shouldBe Down(12)
  }

  test ("Can parse a lit of commands") {
    val strings = Seq(
      "forward 5",
      "down 10",
      "up 55"
    )

    val expectedCommands = Seq(
      Forward(5),
      Down(10),
      Up(55)
    )

    HelmCommand.parseList(strings) shouldBe expectedCommands
  }
