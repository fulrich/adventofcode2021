package com.fulrich.aoc.submarine

case class Position(
  aim: Int = 0,
  depth: Int = 0,
  horizontal: Int = 0):
  
  def calculate: Int = depth * horizontal

object Position:
  def origin: Position = Position(aim = 0, depth = 0, horizontal = 0)