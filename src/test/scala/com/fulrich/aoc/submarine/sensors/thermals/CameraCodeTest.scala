package com.fulrich.aoc.submarine.sensors.thermals

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class CameraCodeTest extends AnyFunSuite:
  val input = Seq(
    "6,10",
    "0,14",
    "9,10",
    "0,3",
    "10,4",
    "4,11",
    "6,0",
    "6,12",
    "4,1",
    "0,13",
    "10,12",
    "3,4",
    "3,0",
    "8,4",
    "1,10",
    "2,14",
    "8,10",
    "9,0",
    "",
    "fold along y=7",
    "fold along x=5"
  )

  test("Can count the number of visible dots") {
    CameraCode(input).fold(1).visibleDots shouldBe 17
  }
