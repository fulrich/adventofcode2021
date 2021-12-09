package com.fulrich.aoc.submarine.displays

case class Digit(output: Seq[Char], mapping: WireMapping):
  lazy val mappedOutput: String = output.map(mapping.apply).sorted.mkString

  lazy val value: Int = mappedOutput match {
    case "abcefg" => 0
    case "cf" => 1
    case "acdeg" => 2
    case "acdfg" => 3
    case "bcdf" => 4
    case "abdfg" => 5
    case "abdefg" => 6
    case "acf" => 7
    case "abcdefg" => 8
    case "abcdfg" => 9
  }

object Digit:
  def parse(input: String, wireMapping: WireMapping = WireMapping.default): Digit = 
    Digit(input.toSeq, wireMapping)