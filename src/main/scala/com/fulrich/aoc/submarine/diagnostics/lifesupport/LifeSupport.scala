package com.fulrich.aoc.submarine.diagnostics.lifesupport

import com.fulrich.aoc.submarine.diagnostics.DiagnosticData
import scala.annotation.tailrec
import javax.tools.Diagnostic
import com.fulrich.aoc.submarine.diagnostics.DiagnosticBit

case class LifeSupport(data: DiagnosticData = DiagnosticData.empty):
  lazy val rating: Int = oxygenGeneratorRating * coScrubberRating
  lazy val oxygenGeneratorRating: Int = findRating(_.gammaBit)
  lazy val coScrubberRating: Int = findRating(_.epsilonBit)

  private def findRating(criteria: DiagnosticBit => Char): Int =
    Integer.parseInt(findRating(data.raw, 0, criteria), 2)

  @tailrec
  private def findRating(dataSet: Seq[String] = data.raw, position: Int = 0, criteria: DiagnosticBit => Char): String = {
    val diagnosticData = DiagnosticData.from(dataSet)
    val filtered = dataSet.filter { value =>
      value.charAt(position) == criteria(diagnosticData.bits(position))
    }

    if filtered.length <= 1 then filtered.head else findRating(filtered, position + 1, criteria)
  }

object LifeSupport:
  def empty: LifeSupport = LifeSupport()
