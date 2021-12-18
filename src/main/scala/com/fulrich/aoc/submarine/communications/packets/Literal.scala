package com.fulrich.aoc.submarine.communications.packets

case class Literal(header: Header, override val value: Long) extends Packet:
  override lazy val versionTotal: Long = header.version

  def print(tab: Int = 0): Unit = {
      val tabs = Seq.fill(tab)(" ").mkString
      println(tabs +  s"Literal(version: ${header.version}, value: $value)")
  }