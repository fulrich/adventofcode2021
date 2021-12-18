package com.fulrich.aoc.submarine.communications.packets

trait Packet:
  def versionTotal: Long
  def value: Long
  def print(tab: Int = 0): Unit