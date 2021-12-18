package com.fulrich.aoc.submarine.communications.packets

trait Operator extends Packet:
  def header: Header
  def packets: Seq[Packet]

  lazy val versionTotal: Long = header.version + packets.map(_.versionTotal).sum

  def print(tab: Int = 0): Unit = {
    val tabs = Seq.fill(tab)(" ").mkString
    println(tabs + s"Operator(Version: ${header.version})")
    packets.map(_.print(tab +  2))
  }

case class SumOperator(header: Header, packets: Seq[Packet]) extends Operator:
  override lazy val value: Long = packets.map(_.value).sum

case class ProductOperator(header: Header, packets: Seq[Packet]) extends Operator:
  override lazy val value: Long = packets.map(_.value).reduce(_ * _)

case class MinimumOperator(header: Header, packets: Seq[Packet]) extends Operator:
  override lazy val value: Long = packets.map(_.value).min

case class MaximumOperator(header: Header, packets: Seq[Packet]) extends Operator:
  override lazy val value: Long = packets.map(_.value).max

case class GreaterThanOperator(header: Header, packets: Seq[Packet]) extends Operator:
  override lazy val value: Long = packets.map(_.value).reduce { case(x, y) => 
    if x > y then 1 else 0
  }

case class LessThanOperator(header: Header, packets: Seq[Packet]) extends Operator:
  override lazy val value: Long = packets.map(_.value).reduce { case(x, y) => 
    if x < y then 1 else 0
  }

case class EqualsOperator(header: Header, packets: Seq[Packet]) extends Operator:
  override lazy val value: Long = packets.map(_.value).reduce { case(x, y) => 
    if x == y then 1 else 0
  }

object Operator:
  def apply(header: Header, packets: Seq[Packet]): Operator = header match {
    case Header(_, 0) => SumOperator(header, packets)
    case Header(_, 1) => ProductOperator(header, packets)
    case Header(_, 2) => MinimumOperator(header, packets)
    case Header(_, 3) => MaximumOperator(header, packets)
    case Header(_, 5) => GreaterThanOperator(header, packets)
    case Header(_, 6) => LessThanOperator(header, packets)
    case Header(_, 7) => EqualsOperator(header, packets)
  }