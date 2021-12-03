package com.fulrich.aoc.submarine.diagnostics

import scala.annotation.targetName

case class DiagnosticData(raw: Seq[String] = Seq.empty, bits: Seq[DiagnosticBit] = Seq.empty):
  def track(input: String): DiagnosticData = copy(bits = zippedBits(input).map(trackBits))
  
  private val trackBits: PartialFunction[(DiagnosticBit, Char), DiagnosticBit] = 
    case (diagnosticBit, inputBit) => diagnosticBit.track(inputBit)

  private def zippedBits(input: String): Seq[(DiagnosticBit, Char)] = {
    val inputBits = input.toCharArray
    bits.padTo(inputBits.length, DiagnosticBit.empty).zip(inputBits)
  }

object DiagnosticData:
  def empty: DiagnosticData = DiagnosticData(raw = Seq.empty, bits = Seq.empty)

  def from(input: Seq[String]): DiagnosticData = 
    input.foldLeft(DiagnosticData(raw = input)) { (diagnostics, nextInput) => 
      diagnostics.track(nextInput) 
    }
