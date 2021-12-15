package com.fulrich.aoc.submarine.hull.polymerization

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class InsertionRulesTest extends AnyFunSuite:
  val rulesInput = Seq(
    "CH -> B",
    "HH -> N",
    "CB -> H",
    "NH -> C",
    "HB -> C",
    "HC -> B",
    "HN -> C",
    "NN -> C",
    "BH -> H",
    "NC -> B",
    "NB -> B",
    "BN -> B",
    "BB -> N",
    "BC -> B",
    "CC -> N",
    "CN -> C"
  )

  test("Can determine the pairs resulting from another pair") {
    val rules = InsertionRules.parse(rulesInput)

    rules.pairs(Pair("NN")) should contain theSameElementsAs Seq(Pair("NC"), Pair("CN"))
    rules.pairs(Pair("HC")) should contain theSameElementsAs Seq(Pair("HB"), Pair("BC"))
  }
