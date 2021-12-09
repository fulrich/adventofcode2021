package com.fulrich.aoc.submarine.displays

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class DigitDisplayTest extends AnyFunSuite:
  test("Can count the number of a list of digits")  {
    val digitDisplay = DigitDisplay(Seq(Digit.parse("cf"), Digit.parse("bcdf"), Digit.parse("cf")))
    
    digitDisplay.countDigits(1) shouldBe 2
    digitDisplay.countDigits(4) shouldBe 1
    digitDisplay.countDigits(1, 4) shouldBe 3
  }

