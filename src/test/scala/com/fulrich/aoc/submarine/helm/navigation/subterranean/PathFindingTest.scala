package com.fulrich.aoc.submarine.helm.navigation.subterranean

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class PathFindingTest extends AnyFunSuite:
  val simpleConnections = Seq(
    "start-A",
    "start-b",
    "A-c",
    "A-b",
    "b-d",
    "A-end",
    "b-end"
  )

  test("Can determine the number of valid paths") {
    PathFinding(simpleConnections).paths.length shouldBe 36
  }

  test("Can determine the valid paths in a more complex set") {
    val pathFinding = PathFinding(Seq( 
      "dc-end",
      "HN-start",
      "start-kj",
      "dc-start",
      "dc-HN",
      "LN-dc",
      "HN-end",
      "kj-sa",
      "kj-HN",
      "kj-dc"
    ))

    pathFinding.paths should have length 103
  }

  test("Can find the number of paths through a complex set") {
    val pathFinding = PathFinding(Seq( 
      "fs-end",
      "he-DX",
      "fs-he",
      "start-DX",
      "pj-DX",
      "end-zg",
      "zg-sl",
      "zg-pj",
      "pj-he",
      "RW-he",
      "fs-DX",
      "pj-RW",
      "zg-RW",
      "start-pj",
      "he-WI",
      "zg-he",
      "pj-fs",
      "start-RW"
    ))

    pathFinding.paths should have length 3509
  }

