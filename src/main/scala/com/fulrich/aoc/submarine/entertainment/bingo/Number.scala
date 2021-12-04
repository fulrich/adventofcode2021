package com.fulrich.aoc.submarine.entertainment.bingo

case class Number(number: Int, at: Location, marked: Boolean = false):
  lazy val unmarked: Boolean = !marked

  def markIf(drawnNumber: Int): Number = if number == drawnNumber then mark else this
  def mark: Number = copy(marked = true)

  def isAt(location: Location): Boolean = location == at
