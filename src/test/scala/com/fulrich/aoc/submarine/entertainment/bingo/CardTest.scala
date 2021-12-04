package com.fulrich.aoc.submarine.entertainment.bingo

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class CardTest extends AnyFunSuite:
  val card = Card(
    Seq(22, 13, 17, 11,  0),
    Seq( 8,  2, 23,  4, 24),
    Seq(21,  9, 14, 16,  7),
    Seq( 6, 10,  3, 18,  5),
    Seq( 1, 12, 20, 15, 19),
  )

  test("Can access number values using row and column") {
    card.at(0, 0).number shouldBe 22
    card.at(1, 1).number shouldBe 2
    card.at(2, 2).number shouldBe 14
    card.at(3, 3).number shouldBe 18
    card.at(4, 4).number shouldBe 19

    card.at(0, 4).number shouldBe 0
    card.at(1, 3).number shouldBe 4
    card.at(2, 2).number shouldBe 14
    card.at(3, 1).number shouldBe 10
    card.at(4, 0).number shouldBe 1
  }

  test("Can mark a number when it is drawn") {
    val markedCard = card.mark(10)

    markedCard.at(3, 1).marked shouldBe true
    markedCard.winner shouldBe false
  }

  test("Can detect a winner when the final row number is marked") {
    val aboutToWin = card.mark(21).mark(9).mark(14).mark(16)
    aboutToWin.winner shouldBe false

    val winningCard = aboutToWin.mark(7)
    winningCard.winner shouldBe true
  }

  test("Can detect a winner when the final column number is marked") {
    val aboutToWin = card.mark(13).mark(2).mark(9).mark(10)
    aboutToWin.winner shouldBe false

    val winningCard = aboutToWin.mark(12)
    winningCard.winner shouldBe true
  }
