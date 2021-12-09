package com.fulrich.aoc.submarine.displays

case class DigitDisplay(output: Seq[Digit]):
  def countDigits(digits: Int*): Int = output.count(digit => digits.contains(digit.value))
  def value: Int = output.map(_.value).mkString.toInt

object DigitDisplay:
  def parse(input: Seq[String], wireMapping: WireMapping = WireMapping.default): DigitDisplay =
    DigitDisplay(input.map(input => Digit.parse(input, wireMapping)))

  def parse(input: String): DigitDisplay = {
    val splitInput = input.split("\\|")
    val signalPatterns = splitInput.head.split(" ").filter(_.nonEmpty)
    val wireMapping = WireMapping(signalPatterns)

    DigitDisplay(
      splitInput.last.split(" ").filter(_.nonEmpty).map(input => Digit.parse(input, wireMapping))
    )
  }