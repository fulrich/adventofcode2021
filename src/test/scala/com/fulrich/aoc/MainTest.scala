package com.fulrich.aoc

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class MainTest extends AnyFunSuite:
  test("Can provide a resource input to determine the resource file to use") {
    val stream = new java.io.ByteArrayOutputStream()

    Console.withOut(stream) {
      Main.main(Array("--resource", "day_1", "--day", "1", "--part", "2"))
    }

    stream.toString should include ("1462")
  }
