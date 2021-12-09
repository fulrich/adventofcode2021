package com.fulrich.aoc.submarine.displays

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class DigitTest extends AnyFunSuite:
  test("Can determine if the digit is one with a unique length") {
    Digit.parse("cf").value shouldBe 1
    Digit.parse("bcdf").value shouldBe 4
    Digit.parse("acf").value shouldBe 7
    Digit.parse("abcdefg").value shouldBe 8
  }

  test("Can parse a string into the character array of a Digit") {
    Digit.parse("acd").output shouldBe Seq('a', 'c', 'd')
  }
