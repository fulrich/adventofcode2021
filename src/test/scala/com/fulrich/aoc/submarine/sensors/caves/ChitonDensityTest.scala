package com.fulrich.aoc.submarine.sensors.caves

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class ChitonDensityTest extends AnyFunSuite:
  val chitonInput = Seq(
    "1163751742",
    "1381373672",
    "2136511328",
    "3694931569",
    "7463417111",
    "1319128137",
    "1359912421",
    "3125421639",
    "1293138521",
    "2311944581"
  )

  test("mini test") {
    val density = ChitonDensity.parse(Seq(
      "116",
      "138",
      "213"
    ))
    
    density.lowestRisk shouldBe 7
  }

  test("Can determine the risk level of the safest path") {
    ChitonDensity.parse(chitonInput).lowestRisk shouldBe 40
  }

  test("Can increase the Grid size") {
    val density = ChitonDensity.parse(chitonInput)
    val increased = density.increaseGrid(5)

    increased.chitons.width shouldBe (density.chitons.width * 5)
    increased.chitons.height shouldBe (density.chitons.height * 5)
    increased.lowestRisk shouldBe 315
  }
