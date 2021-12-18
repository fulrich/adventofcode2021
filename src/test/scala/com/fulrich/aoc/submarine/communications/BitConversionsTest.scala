package com.fulrich.aoc.submarine.communications

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class BitConversionTest extends AnyFunSuite:
  test("Can convert from a character to binary") {
    '0'.hexToBinary shouldBe "0000"
    '1'.hexToBinary shouldBe "0001"
    '2'.hexToBinary shouldBe "0010"
    '3'.hexToBinary shouldBe "0011"
    'C'.hexToBinary shouldBe "1100"
    'D'.hexToBinary shouldBe "1101"
    'E'.hexToBinary shouldBe "1110"
    'F'.hexToBinary shouldBe "1111"
  }

  test("Can convert from a decimal string to an integer") {
    "0100".binaryToDecimal shouldBe 4
    "1100".binaryToDecimal shouldBe 12
  }
