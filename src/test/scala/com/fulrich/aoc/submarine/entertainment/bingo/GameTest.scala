package com.fulrich.aoc.submarine.entertainment.bingo

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class GameTest extends AnyFunSuite:
  val draws = Seq(
    7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1
  )

  val card1 = Card(
    Seq(22, 13, 17, 11,  0),
    Seq( 8,  2, 23,  4, 24),
    Seq(21,  9, 14, 16,  7),
    Seq( 6, 10,  3, 18,  5),
    Seq( 1, 12, 20, 15, 19),
  )

  val card2 = Card(
    Seq( 3, 15,  0,  2, 22),
    Seq( 9, 18, 13, 17,  5),
    Seq(19,  8,  7, 25, 23),
    Seq(20, 11, 10, 24,  4),
    Seq(14, 21, 16, 12,  6),
  )

  val card3 = Card(
    Seq(14, 21, 17, 24,  4),
    Seq(10, 16, 15,  9, 19),
    Seq(18,  8, 23, 26, 20),
    Seq(22, 11, 13,  6,  5),
    Seq( 2,  0, 12,  3,  7),
  )

  test("Can play a full game and detect the winner") {
    val setup = GameSetup(draws, Seq(card1, card2, card3))
    val game = new Game(setup)

    game.play().score shouldBe 4512
  }

  test("Can play a full game and detect which card will win last") {
    val setup = GameSetup(draws, Seq(card1, card2, card3))
    val game = new Game(setup)

    game.playToLose().score shouldBe 1924
  }
