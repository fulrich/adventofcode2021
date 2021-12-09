package com.fulrich.aoc.submarine.displays

case class Displays(all: Seq[DigitDisplay]):
  def countDigits(digits: Int*): Int = all.map(_.countDigits(digits: _*)).sum
  def total: Int = all.map(_.value).sum

object Displays:
  def parse(input: Seq[String]): Displays =
    Displays(all = input.map(DigitDisplay.parse))
