package com.fulrich.aoc.input

import com.fulrich.aoc.submarine.diagnostics.DiagnosticData
import com.fulrich.aoc.submarine.helm.HelmCommand
import com.fulrich.aoc.submarine.entertainment.bingo.{Card, GameSetup}
import com.fulrich.aoc.input.DataInput

object Deserialization:
  given toSeqInt: Conversion[DataInput, Seq[Int]] with
    def apply(input: DataInput): Seq[Int] = input.raw.map(_.toInt)

  given toSeqString: Conversion[DataInput, Seq[String]] with
    def apply(input: DataInput): Seq[String] = input.raw

  given toDiagnosticData: Conversion[DataInput, DiagnosticData] with
    def apply(input: DataInput): DiagnosticData = DiagnosticData.from(input.raw)

  given toSeqHelmCommand: Conversion[DataInput, Seq[HelmCommand]] with
    def apply(input: DataInput): Seq[HelmCommand] = input.map(HelmCommand.parse)

  given toBingoGameSetup: Conversion[DataInput, GameSetup] with
    def apply(input: DataInput): GameSetup = {
      val draws = input.raw.head.split(",")map(_.toInt)
      val cards = input.raw.tail.grouped(6).map { rawCard => {
          val validLines = rawCard.filter(_.nonEmpty)
          val cardData = validLines.map(_.split(" ").filter(_.nonEmpty).toSeq.map(_.toInt))
          Card(cardData:_ *)
        }
      }.toSeq

      GameSetup(draws = draws, cards = cards)
    }
    