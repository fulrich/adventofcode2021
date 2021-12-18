package com.fulrich.aoc.submarine.communications.processing

import com.fulrich.aoc.submarine.communications._
import com.fulrich.aoc.submarine.communications.packets._

case class ProcessLiteral(header: Header, private val raw: Raw) extends Processing:
  lazy val isComplete: Boolean = indicatorDigit.contains('0') && groupComplete
  lazy val packet: Option[Literal] = if isComplete then Some(Literal(header, asDigit)) else None

  lazy val indicatorDigit: Option[Char] = raw.lift(indicatorIndex)
  lazy val indicatorIndex: Int = Math.max((Math.ceil(raw.length / 5D).toInt - 1) * 5, 0)
  lazy val groupComplete: Boolean = raw.length == (indicatorIndex + 5)

  override def next(digit: Char): ProcessLiteral = copy(raw = raw + digit)

  lazy val asDigit: Long = raw.grouped(5).foldLeft("") { 
    case (binaryString, chunk) => binaryString + chunk.tail
  }.binaryToDecimal


object ProcessLiteral:
  def empty(version: Long, typeId: Long): ProcessLiteral = empty(Header(version, typeId))
  def empty(header: Header): ProcessLiteral = ProcessLiteral(header, Raw.empty)

  def apply(version: Long, typeId: Long, raw: Raw): ProcessLiteral = ProcessLiteral(Header(version, typeId), raw)
