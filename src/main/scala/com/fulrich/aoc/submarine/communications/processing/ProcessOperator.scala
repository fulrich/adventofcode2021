package com.fulrich.aoc.submarine.communications.processing

import com.fulrich.aoc.submarine.communications._
import com.fulrich.aoc.submarine.communications.packets._

sealed trait ProcessOperator extends Processing:
  def header: Header
  lazy val isComplete: Boolean = false
  lazy val packet: Option[Packet] = None

case class IdentifyLengthType(override val header: Header, private val raw: Raw) extends ProcessOperator:
  override def next(digit: Char): ProcessOperator = copy(raw = raw + digit).process

  def process: ProcessOperator = if raw.isEmpty then this else raw.head match {
    case '0' => BitBasedLength(header, raw.tail)
    case '1' => PacketBasedLength(header, raw.tail)
  }

case class PacketBasedLength(override val header: Header, private val raw: Raw) extends ProcessOperator:
  val length = 11

  override def next(digit: Char): ProcessOperator = copy(raw = raw + digit).process

  def process: ProcessOperator = 
    if raw.length == length then SubPacketsByCount(header, raw.take(length).binaryToDecimal) else this

case class BitBasedLength(override val header: Header, private val raw: Raw) extends ProcessOperator:
  val length = 15

  override def next(digit: Char): ProcessOperator = copy(raw = raw + digit).process

  def process: ProcessOperator = 
    if raw.length == length then SubPacketsByBits(header, raw.take(length).binaryToDecimal) else this


case class SubPacketsByCount(
  override val header: Header, 
  packetCount: Long, 
  processor: Processor = Processor.empty) extends ProcessOperator:

  override lazy val isComplete: Boolean = processor.packets.length == packetCount
  override def next(digit: Char): ProcessOperator = copy(processor = processor.next(digit))
  override lazy val packet: Option[Packet] = if isComplete then Some(Operator(header, processor.packets)) else None

case class SubPacketsByBits(
  override val header: Header, 
  bitCount: Long,
  processed: Long = 0, 
  processor: Processor = Processor.empty) extends ProcessOperator:

  override lazy val isComplete: Boolean = processed == bitCount
  override def next(digit: Char): ProcessOperator = copy(processor = processor.next(digit), processed = processed + 1)
  override lazy val packet: Option[Packet] = if isComplete then Some(Operator(header, processor.packets)) else None

object ProcessOperator:
  def apply(header: Header, raw: Raw): ProcessOperator = IdentifyLengthType(header, raw)
  def apply(version: Int, typeId: Int, raw: Raw): ProcessOperator = apply(Header(version, typeId), raw)
