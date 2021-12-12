package com.fulrich.aoc.algebra

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class GridTest extends AnyFunSuite:
  val testInput = Seq(
    "123",
    "456",
    "789"
  )

  val grid  = Grid.parse(testInput) { (key, value) => value.asDigit }
  
  test("Can create a grid from a list of strings") {
    grid.at(0, 0) should contain (1)
    grid.at(1, 0) should contain (2)
    grid.at(2, 0) should contain (3)

    grid.at(0, 1) should contain (4)
    grid.at(1, 1) should contain (5)
    grid.at(2, 1) should contain (6)

    grid.at(0, 2) should contain (7)
    grid.at(1, 2) should contain (8)
    grid.at(2, 2) should contain (9)
  }

  test("Can transform the values at specific positions in a Grid") {
    val positions = Seq(Coordinate(1, 1), Coordinate(2, 2))
    val transformed = grid.transformAt(positions)(_ + 10)

    transformed.at(0, 0) should contain (1)
    transformed.at(1, 0) should contain (2)
    transformed.at(2, 0) should contain (3)

    transformed.at(0, 1) should contain (4)
    transformed.at(1, 1) should contain (15)
    transformed.at(2, 1) should contain (6)

    transformed.at(0, 2) should contain (7)
    transformed.at(1, 2) should contain (8)
    transformed.at(2, 2) should contain (19)
  }

  test("transformAt allows the the same position to be transformed multiple times") {
    val positions = Seq(Coordinate(1, 1), Coordinate(1, 1))
    val transformed = grid.transformAt(positions)(_ + 10)

    transformed.at(1, 1) should contain (25)
  }

  test("Can map the values of the grid") {
    val mapped = grid.mapValues(_ + 10)

    mapped.at(0, 0) should contain (11)
    mapped.at(1, 0) should contain (12)
    mapped.at(2, 0) should contain (13)

    mapped.at(0, 1) should contain (14)
    mapped.at(1, 1) should contain (15)
    mapped.at(2, 1) should contain (16)

    mapped.at(0, 2) should contain (17)
    mapped.at(1, 2) should contain (18)
    mapped.at(2, 2) should contain (19)
  }

  test("Can get all the keys of the grid") {
    grid.keys should contain theSameElementsAs Seq(
      Coordinate(0, 0),
      Coordinate(1, 0),
      Coordinate(2, 0),
      Coordinate(0, 1),
      Coordinate(1, 1),
      Coordinate(2, 1),
      Coordinate(0, 2),
      Coordinate(1, 2),
      Coordinate(2, 2)
    )
  }

  test("Can get all the values of the grid") {
    grid.values should contain theSameElementsAs Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)
  }
