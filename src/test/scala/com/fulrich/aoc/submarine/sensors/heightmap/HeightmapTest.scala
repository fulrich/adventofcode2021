package com.fulrich.aoc.submarine.sensors.heightmap

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class HeightmapTest extends AnyFunSuite:
  val heightMap = Heightmap.parse(Seq(
    "2199943210",
    "3987894921",
    "9856789892",
    "8767896789",
    "9899965678"
  ))

  test("Can find the area of the n largest basins") {
    heightMap.areaOfLargestBasins(numberOfBasins = 3) shouldBe 1134
  }

  test("Can find all the basins in a height map") {
    heightMap.basins.map(_.size) should contain theSameElementsAs Seq(
      3, 9, 14, 9
    )
  }

  test("Can calculate the risk level of all low points") {
    heightMap.lowPointsRisk shouldBe 15
  }

  test("Can find the lowest points in the height map") {
    heightMap.lowHeights should have length 4

    heightMap.lowHeights should contain theSameElementsAs Seq(
      Height(x = 1, y = 0, height = 1),
      Height(x = 9, y = 0, height = 0),
      Height(x = 2, y = 2, height = 5),
      Height(x = 6, y = 4, height = 5)
    )
  }
