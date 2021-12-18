package com.fulrich.aoc.submarine.communications.packets

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class PacketTest extends AnyFunSuite:
  test("Can process the version and type id before moving to the next step") {
    Header(3, 1) shouldBe Header(3, 1)
  }
