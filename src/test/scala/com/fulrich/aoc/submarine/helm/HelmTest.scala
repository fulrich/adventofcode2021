package com.fulrich.aoc.submarine.helm

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input.PuzzleInput
import com.fulrich.aoc.submarine.Position

class HelmTest extends AnyFunSuite:
  val helm = new Helm
  
  test("navigate can handle a list of commands") {
    val commands = Seq(
      Forward(100),
      Down(2),
      Forward(5)
    )

    val expectedPosition = Position(aim = 2, depth = 10, horizontal = 105)

    helm.navigate(commands, Position.origin) shouldBe expectedPosition
  }

  test("navigate increases the aim on a Down command") {
    helm.navigate(Position(aim = 10), Down(5)) shouldBe Position(aim = 15)
  }

  test("navigate decreases the aim on an Up command") {
    helm.navigate(Position(aim = 10), Up(5)) shouldBe Position(aim = 5)
  }

  test("navigate increases depth and horizontal position on a Forward command") {
    val startPosition = Position(aim = 2, depth = 10, horizontal = 100)
    val expectedPosition = Position(aim = 2, depth = 20, horizontal = 105)

    helm.navigate(startPosition, Forward(5)) shouldBe expectedPosition
  }