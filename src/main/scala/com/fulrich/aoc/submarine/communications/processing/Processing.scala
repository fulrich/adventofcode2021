package com.fulrich.aoc.submarine.communications.processing

import com.fulrich.aoc.submarine.communications.packets._

trait Processing:
  def isComplete: Boolean
  def next(digit: Char): Processing
  def packet: Option[Packet]

object Processing:
  def start(digit: Char): Processing = Identifying.start(digit)
