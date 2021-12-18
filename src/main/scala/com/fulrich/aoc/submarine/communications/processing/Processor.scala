package com.fulrich.aoc.submarine.communications.processing

import com.fulrich.aoc.submarine.communications._
import com.fulrich.aoc.submarine.communications.packets._

case class Processor(processing: Option[Processing], packets: Seq[Packet]):
  def next(digit: String): Processor = digit.toSeq.foldLeft(this) { case(processor, digit) => processor.next(digit) }

  def next(digit: Char): Processor = processing match {
    case Some(process) => continue(process.next(digit))
    case None => start(digit)
  }

  private def continue(nextStep: Processing): Processor = 
    if nextStep.isComplete then completePacket(nextStep) else copy(processing = Some(nextStep))

  private def start(digit: Char): Processor = copy(processing  = Some(Processing.start(digit)))
  private def completePacket(complete: Processing): Processor = copy(processing = None, packets = packets ++ complete.packet)

object Processor:
  def empty: Processor = Processor(None, Seq.empty)
