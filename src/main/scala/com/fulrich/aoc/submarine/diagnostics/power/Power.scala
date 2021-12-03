package com.fulrich.aoc.submarine.diagnostics.power

import com.fulrich.aoc.submarine.diagnostics.DiagnosticData

case class Power(data: DiagnosticData = DiagnosticData.empty):
  lazy val consumption: Int = epsilonRate * gammaRate

  lazy val epsilonRate: Int = Integer.parseInt(data.bits.map(_.epsilonBit).mkString, 2)
  lazy val gammaRate: Int = Integer.parseInt(data.bits.map(_.gammaBit).mkString, 2)


object Power:
  def empty: Power = Power()