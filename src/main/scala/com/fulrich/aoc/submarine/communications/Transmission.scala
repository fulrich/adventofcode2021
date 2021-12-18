package com.fulrich.aoc.submarine.communications

import processing._
import packets._

case class Transmission(packets: Seq[Packet], remaining: String = ""):
  lazy val versionTotal = packets.map(_.versionTotal).sum
  lazy val value: Long = packets.head.value

  def print: Unit = {
    println(s"Transmission(remaining: ${remaining}, packets: ${packets.length})")
    packets.map(_.print(2))
  }

object Transmission:
  def apply(input: String): Transmission = Transmission(
    input.toSeq.foldLeft(Processor.empty) { case(transmission, chunk) =>
      transmission.next(chunk.hexToBinary)
    }.packets
  )
