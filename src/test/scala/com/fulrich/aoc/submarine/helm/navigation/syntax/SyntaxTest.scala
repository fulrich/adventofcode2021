package com.fulrich.aoc.submarine.helm.navigation.syntax

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import ChunkPart._
import org.scalactic._

class SyntaxTest extends AnyFunSuite:
  val input = Seq(
    "[({(<(())[]>[[{[]{<()<>>",
    "[(()[<>])]({[<{<<[]>>(",
    "{([(<{}[<>[]}>{[]{[(<()>",
    "(((({<>}<{<{<>}{[]{[]{}",
    "[[<[([]))<([[{}[[()]]]",
    "[{[{({}]{}}([{[{{{}}([]",
    "{<[[]]>}<{[{[{[]{()[[[]",
    "[<(<(<(<{}))><([]([]()",
    "<{([([[(<>()){}]>(<<{{",
    "<{([{{}}[<[[[<>{}]]]>[]]"
  )

  test("Can determine a auto complete score") {
    Syntax.validate(input).autoCompleteScore shouldBe 288957
  }

  test("Can determine a validation score") {
    Syntax.validate(input).validationScore shouldBe 26397
  }
  
  test("Returns all the invalid ChunkParts when parsing can't be done") {
    Syntax.validate(input).invalidParts shouldBe Seq(
      CurlyClose,
      RoundClose,
      SquareClose,
      RoundClose,
      AngleClose
    )
  }
