package com.fulrich.aoc.submarine.communications.processing

import com.fulrich.aoc.submarine.communications._
import com.fulrich.aoc.submarine.communications.packets._

sealed trait Identifying extends Processing:
  lazy val isComplete: Boolean = false
  lazy val packet: Option[Packet] = None

case class IdentifyingVersion(private val raw: Raw) extends Identifying:
  override def next(digit: Char): Identifying = copy(raw = raw + digit).process
  private def process: Identifying = if raw.length >= 3 then nextStep else this
  private def nextStep: IdentifyingType = IdentifyingType(raw.drop(3), raw.take(3).binaryToDecimal)

case class IdentifyingType(private val raw: Raw, version: Long) extends Identifying:
  override def next(digit: Char): Processing = copy(raw = raw + digit).process
  private def process: Processing = if raw.length >= 3 then nextStep else this
  def nextStep: Processing = raw.take(3).binaryToDecimal match {
    case 4 => ProcessLiteral(Header(version, 4), raw.drop(3))
    case typeId => ProcessOperator(Header(version, typeId), raw.drop(3))
  }

object Identifying:
  val empty = IdentifyingVersion(Raw.empty)

  def start(digit: Char): Identifying = empty.next(digit)
