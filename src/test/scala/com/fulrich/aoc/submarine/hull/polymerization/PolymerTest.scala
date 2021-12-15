package com.fulrich.aoc.submarine.hull.polymerization

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class PolymerTest extends AnyFunSuite:
  val input = Seq(
    "NNCB",
    "",
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

  test("Can count the number of character after 10 steps") {
    val polymer = Polymer.parse(input).steps(10)

    polymer.length shouldBe 3073
    polymer.count('B') shouldBe 1749
    polymer.count('C') shouldBe 298
    polymer.commonalityDifference shouldBe 1588
  }

  test("Can move forward a single step at a time")  {
    val polymer = Polymer.parse(input)
    val singleStep = polymer.step
    val doubleStep = singleStep.step
    
    singleStep.length shouldBe 7
    singleStep.pairs should contain theSameElementsAs Seq(Pair("NC"), Pair("CN"), Pair("NB"), Pair("BC"), Pair("CH"), Pair("HB"))

    doubleStep.length shouldBe 13
  }

  test("Can load the initial pairs")  {
    val polymer = Polymer.parse(input)
    
    polymer.length shouldBe 4
    polymer.pairs should contain theSameElementsAs Seq(Pair("NN"), Pair("NC"), Pair("CB"))

    polymer.count(Pair("NN")) shouldBe 1
    polymer.count(Pair("NC")) shouldBe 1
    polymer.count(Pair("CB")) shouldBe 1
  }

  test("Can move forward multiple steps with the steps command")  {
    val polymer = Polymer.parse(input)

    polymer.step shouldBe polymer.steps(1)
    polymer.step.step.step shouldBe polymer.steps(3)
  }

  test("Can load the insertion rules") {
    val polymer = Polymer.parse(input)

    polymer.rules shouldBe InsertionRules(Map(
      Pair("CH") -> 'B',
      Pair("HH") -> 'N',
      Pair("CB") -> 'H',
      Pair("NH") -> 'C',
      Pair("HB") -> 'C',
      Pair("HC") -> 'B',
      Pair("HN") -> 'C',
      Pair("NN") -> 'C',
      Pair("BH") -> 'H',
      Pair("NC") -> 'B',
      Pair("NB") -> 'B',
      Pair("BN") -> 'B',
      Pair("BB") -> 'N',
      Pair("BC") -> 'B',
      Pair("CC") -> 'N',
      Pair("CN") -> 'C'
    ))
  }
