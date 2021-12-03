package com.fulrich.aoc.submarine.diagnostics

case class DiagnosticBit(oneCount: Int = 0, zeroCount: Int = 0):
  def track(bit: Char): DiagnosticBit = bit match {
    case '0' => copy (zeroCount = zeroCount + 1)
    case '1' => copy (oneCount = oneCount + 1)
    case _ => this
  }

  def gammaBit: Char = if oneCount >= zeroCount then '1' else '0'
  def epsilonBit: Char = if oneCount < zeroCount then '1' else '0'

object DiagnosticBit:
  def empty: DiagnosticBit = DiagnosticBit()