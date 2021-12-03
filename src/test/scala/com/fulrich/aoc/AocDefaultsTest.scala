package com.fulrich

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import java.time.{ Clock, LocalDate, ZoneId }
import com.fulrich.aoc.AocDefaults

class AocDefaultsTest extends AnyFunSuite:
  test("Chooses the day based on the current clock") {
    AocDefaults.fixed("2021-11-29").day shouldBe 1
    AocDefaults.fixed("2021-12-01").day shouldBe 1
    AocDefaults.fixed("2021-12-05").day shouldBe 5
    AocDefaults.fixed("2021-12-26").day shouldBe 25
  }

  private def fixedClock(dateString: String): Clock = {
    Clock.fixed(
      LocalDate.parse(dateString).atStartOfDay(ZoneId.systemDefault()).toInstant(),
      ZoneId.systemDefault()
    )
  }
