package com.fulrich.aoc.submarine.helm.navigation.syntax

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import ChunkPart._
import org.scalactic._

class ChunkPairTest extends AnyFunSuite:
  test("Can lookup a pair by the opening part") {
    ChunkPair.byOpen(CurlyOpen) should contain (ChunkPair(CurlyOpen, CurlyClose))
  }

  test("Can lookup a pair by the closing part") {
    ChunkPair.byClose(CurlyClose) should contain (ChunkPair(CurlyOpen, CurlyClose))
  }

  test("Can detect an invalid closing pair when validating") {
    ChunkPair.validate(open = RoundOpen, close = CurlyClose) shouldBe Bad(One(CurlyClose))
    ChunkPair.validate(open = RoundOpen, close = AngleClose) shouldBe Bad(One(AngleClose))
  }
