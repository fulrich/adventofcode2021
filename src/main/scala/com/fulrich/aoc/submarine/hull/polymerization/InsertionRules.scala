package com.fulrich.aoc.submarine.hull.polymerization

case class InsertionRules(rules: Map[Pair, Char]):
  def pairs(pair: Pair): Seq[Pair] = rules.get(pair).map { insertionChar =>
    Seq(Pair(pair.left, insertionChar), Pair(insertionChar, pair.right))
  }.getOrElse(Seq(pair))

object InsertionRules:
  val Delimiter = " -> "

  def parse(inputs: Seq[String]): InsertionRules =  InsertionRules(inputs.map(parse).toMap)

  def parse(input: String): (Pair, Char) = input.split(Delimiter) match {
    case Array(pair, insertion) => Pair(pair) -> insertion.head
  }
