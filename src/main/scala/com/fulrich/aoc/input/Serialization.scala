package com.fulrich.aoc.input

import com.fulrich.aoc.submarine.diagnostics.DiagnosticData
import com.fulrich.aoc.submarine.helm.HelmCommand
import com.fulrich.aoc.input.DataInput

object Serialization:
  given toSeqInt: Conversion[DataInput, Seq[Int]] with
    def apply(input: DataInput): Seq[Int] = input.raw.map(_.toInt)

  given toSeqString: Conversion[DataInput, Seq[String]] with
    def apply(input: DataInput): Seq[String] = input.raw

  given toDiagnosticData: Conversion[DataInput, DiagnosticData] with
    def apply(input: DataInput): DiagnosticData = DiagnosticData.from(input.raw)

  given toSeqHelmCommand: Conversion[DataInput, Seq[HelmCommand]] with
    def apply(input: DataInput): Seq[HelmCommand] = input.map(HelmCommand.parse)