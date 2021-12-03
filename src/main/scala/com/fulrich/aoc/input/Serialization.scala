package com.fulrich.aoc.input

import com.fulrich.aoc.submarine.diagnostics.DiagnosticData
import com.fulrich.aoc.submarine.helm.HelmCommand
import com.fulrich.aoc.input.PuzzleInput

object Serialization:
  given toSeqInt: Conversion[PuzzleInput, Seq[Int]] with
    def apply(input: PuzzleInput): Seq[Int] = input.raw.map(_.toInt)

  given toSeqString: Conversion[PuzzleInput, Seq[String]] with
    def apply(input: PuzzleInput): Seq[String] = input.raw

  given toDiagnosticData: Conversion[PuzzleInput, DiagnosticData] with
    def apply(input: PuzzleInput): DiagnosticData = DiagnosticData.from(input.raw)

  given toSeqHelmCommand: Conversion[PuzzleInput, Seq[HelmCommand]] with
    def apply(input: PuzzleInput): Seq[HelmCommand] = input.map(HelmCommand.parse)