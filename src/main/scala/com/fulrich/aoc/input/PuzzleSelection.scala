package com.fulrich.aoc.input

import java.time.temporal.ChronoUnit;
import java.time.{ Clock, LocalDate };

case class PuzzleSelection(day: Int, part: Int)

object PuzzleSelection:
  val MaximumAdventCalendarDays = 25

  def apply(day: Option[Int] = None, part: Option[Int] = None, clock: Clock = Clock.systemDefaultZone()): PuzzleSelection =
    PuzzleSelection(
      day = day.getOrElse(calculateDay(clock)),
      part = part.getOrElse(1)
    )

  private def calculateDay(clock: Clock): Int = {
    val startOfAoc = LocalDate.parse("2021-12-01");
    val calculatedDay = ChronoUnit.DAYS.between(startOfAoc, LocalDate.now(clock)).toInt + 1;

    Math.max(1, Math.min(calculatedDay, MaximumAdventCalendarDays))
  }
  