package com.fulrich.aoc

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class MainTest extends AnyFunSuite:
  test("Uses the default resource file if no resource is provided") {
    val stream = new java.io.ByteArrayOutputStream()

    Console.withOut(stream) {
      Main.main(Array.empty)
    }

    stream.toString should include ("Advent of Code 2021!")
    stream.toString should include ("I was compiled by Scala 3. :)")
  }

  test("Can provide a resource input to determine the resource file to use") {
    val stream = new java.io.ByteArrayOutputStream()

    Console.withOut(stream) {
      Main.main(Array("--resource", "other_test"))
    }

    stream.toString should include ("Testing Resources!")
    stream.toString should include ("Multiline Output!")
  }
