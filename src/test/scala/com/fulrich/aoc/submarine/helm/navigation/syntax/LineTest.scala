package com.fulrich.aoc.submarine.helm.navigation.syntax

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import ChunkPart._
import org.scalactic._

class LineText extends AnyFunSuite:
  test("Can determine the autocomplete score for a line") {
    Line.validate("[({(<(())[]>[[{[]{<()<>>").autoCompleteScore shouldBe 288957
    Line.validate("[(()[<>])]({[<{<<[]>>(").autoCompleteScore shouldBe 5566
    Line.validate("(((({<>}<{<{<>}{[]{[]{}").autoCompleteScore shouldBe 1480781
    Line.validate("{<[[]]>}<{[{[{[]{()[[[]").autoCompleteScore shouldBe 995444
    Line.validate("<{([{{}}[<[[[<>{}]]]>[]]").autoCompleteScore shouldBe 294
  }

  test("Can detect the incomplete parts of the line") {
    Line.validate("[({(<(())[]>[[{[]{<()<>>").completedBy shouldBe ChunkPart.from("}}]])})]")
    Line.validate("[(()[<>])]({[<{<<[]>>(").completedBy shouldBe ChunkPart.from(")}>]})")
    Line.validate("(((({<>}<{<{<>}{[]{[]{}").completedBy shouldBe ChunkPart.from("}}>}>))))")
    Line.validate("{<[[]]>}<{[{[{[]{()[[[]").completedBy shouldBe ChunkPart.from("]]}}]}]}>")
    Line.validate("<{([{{}}[<[[[<>{}]]]>[]]").completedBy shouldBe ChunkPart.from("])}>")
  }

  test("Can detect the first invalid part of a line") {
    Line.validate("(}").invalid should contain (CurlyClose)
  }

  test("Can detect the first invalid part of a complex line") {
    Line.validate("{([(<{}[<>[]}>{[]{[(<()>").invalid should contain (CurlyClose)
    Line.validate("[[<[([]))<([[{}[[()]]]").invalid should contain (RoundClose)
    Line.validate("[{[{({}]{}}([{[{{{}}([]").invalid should contain (SquareClose)
    Line.validate("[<(<(<(<{}))><([]([]()").invalid should contain (RoundClose)
    Line.validate("<{([([[(<>()){}]>(<<{{").invalid should contain (AngleClose)
  }

  test("Can detect when a line is valid") {
    Line.validate("()") shouldBe Line(processed = Seq(RoundOpen, RoundClose))
    Line.validate("()[]") shouldBe Line(processed = Seq(RoundOpen, RoundClose, SquareOpen, SquareClose))
    Line.validate("([])") shouldBe Line(processed = Seq(RoundOpen, SquareOpen, SquareClose, RoundClose))
    Line.validate("([]){<>}") shouldBe Line(processed = Seq(
      RoundOpen, SquareOpen, SquareClose, RoundClose, 
      CurlyOpen, AngleOpen,  AngleClose, CurlyClose
    ))
  }

  test("Can detect complex line sequences") {
    Line.validate("{()()()}").isValid shouldBe true
    Line.validate("<([{}])>").isValid shouldBe true
    Line.validate("[<>({}){}[([])<>]]").isValid shouldBe true
    Line.validate("(((((((((())))))))))").isValid shouldBe true
  }
