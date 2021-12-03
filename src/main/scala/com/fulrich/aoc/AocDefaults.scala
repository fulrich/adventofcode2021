package com.fulrich.aoc

import java.time.temporal.ChronoUnit;
import java.time.{ Clock, LocalDate, ZoneId }

class AocDefaults(clock: Clock = Clock.systemDefaultZone()):
  def day: Int = {
    val startOfAoc = LocalDate.parse("2021-12-01");
    val calculatedDay = ChronoUnit.DAYS.between(startOfAoc, LocalDate.now(clock)).toInt + 1;

    Math.max(1, Math.min(calculatedDay, 25))
  }

object AocDefaults:
  def fixed(dateString: String): AocDefaults = AocDefaults(
    Clock.fixed(
      LocalDate.parse(dateString).atStartOfDay(ZoneId.systemDefault()).toInstant(),
      ZoneId.systemDefault()
    )
  )
