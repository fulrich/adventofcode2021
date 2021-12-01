package com.fulrich.aoc.input

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import java.time.{ Clock, LocalDate, ZoneId }

class PuzzleSelectionTest extends AnyFunSuite:
  test("Chooses the day based on the current clock") {
    PuzzleSelection(clock = fixedClock("2021-11-29")).day shouldBe 1
    PuzzleSelection(clock = fixedClock("2021-12-01")).day shouldBe 1
    PuzzleSelection(clock = fixedClock("2021-12-05")).day shouldBe 5
    PuzzleSelection(clock = fixedClock("2021-12-26")).day shouldBe 25
  }

  test("Defaults to part 1 if no part is selected") {
    val selection = PuzzleSelection(day = Some(12))
    
    selection.day shouldBe 12
    selection.part shouldBe 1
  }

  test("Can specific a day and a part") {
    val selection = PuzzleSelection(day = Some(5), part = Some(2))
    
    selection.day shouldBe 5
    selection.part shouldBe 2
  }

  private def fixedClock(dateString: String): Clock = {
    Clock.fixed(
      LocalDate.parse(dateString).atStartOfDay(ZoneId.systemDefault()).toInstant(),
      ZoneId.systemDefault()
    )
  }
