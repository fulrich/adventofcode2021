package com.fulrich.aoc.submarine.hull.polymerization

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class PairTest extends AnyFunSuite:
  test("Can parse a set of pairs from a string") {
    Pair("QR") shouldBe Pair(left = 'Q', right = 'R')
    Pair("NN") shouldBe Pair(left = 'N', right = 'N')
  }