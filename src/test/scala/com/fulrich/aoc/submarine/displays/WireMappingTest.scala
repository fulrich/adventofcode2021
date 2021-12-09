package com.fulrich.aoc.submarine.displays

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class WireMappingTest extends AnyFunSuite:
  val signals = Seq("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
  val mapping = WireMapping(signals)

  test("Can map correctly")  {
    mapping('d') shouldBe 'a'
    mapping('e') shouldBe 'b'
    mapping('a') shouldBe 'c'
    mapping('f') shouldBe 'd'
    mapping('g') shouldBe 'e'
    mapping('b') shouldBe 'f'
    mapping('c') shouldBe 'g'
  }
