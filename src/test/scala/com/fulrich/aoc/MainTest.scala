package com.fulrich.aoc

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class MainTest extends AnyFunSuite:
  test("message test") {
    msg shouldBe "I was compiled by Scala 3. :)"
  }
