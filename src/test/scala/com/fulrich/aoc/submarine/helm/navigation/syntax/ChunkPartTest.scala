package com.fulrich.aoc.submarine.helm.navigation.syntax

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import ChunkPart._

class ChunkPartTest extends AnyFunSuite:
  test("Can create a sequence of chunk parts from a string") {
    ChunkPart.from("{}") shouldBe Seq(CurlyOpen, CurlyClose)
  }
