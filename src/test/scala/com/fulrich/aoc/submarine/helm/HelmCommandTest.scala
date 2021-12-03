package com.fulrich.aoc.submarine.helm

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

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
