package com.fulrich.aoc.submarine

case class Position(
  aim: Int = 0,
  depth: Int = 0,
  horizontal: Int = 0
)

object Position:
  def origin: Position = Position(aim = 0, depth = 0, horizontal = 0)