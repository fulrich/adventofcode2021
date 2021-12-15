package com.fulrich.aoc.submarine.hull.polymerization

case class Polymer(pairCounts: Map[Pair,  Long],  rules: InsertionRules):
  lazy val pairs: Seq[Pair] = pairCounts.filterNot(_._2 == 0).keys.toSeq
  lazy val length: Long = pairCounts.values.sum + 1

  lazy val breakdown = pairCounts.groupMapReduce(_._1.right)(_._2)(_ + _)
  lazy val leastCommon = breakdown.minBy(_._2)._1
  lazy val mostCommon = breakdown.maxBy(_._2)._1
  lazy val commonalityDifference = breakdown(mostCommon) - breakdown(leastCommon)

  def count(pair: Pair): Long = pairCounts.get(pair).getOrElse(0)
  def count(character: Char): Long = breakdown.get(character).getOrElse(0)

  def steps(count: Int): Polymer = if count == 0 then this else step.steps(count - 1)
  def step: Polymer = {
    val nextPairs = nextPairCounts(rules)
    val newPairCounts = (pairs ++ nextPairs.keys).distinct.collect { pair => (pairCounts.get(pair), nextPairs.get(pair)) match {
      case (None, Some(newCount)) => pair -> newCount
      case (Some(previousCount), Some(newCount)) => pair -> newCount
    } }

    copy(pairCounts = newPairCounts.toMap)
  }

  private def nextPairCounts(rules: InsertionRules): Map[Pair, Long] =
    pairCounts.keys.toSeq.flatMap { pair =>
      rules.pairs(pair).map { newPair =>
        newPair -> pairCounts(pair)
      }
    }.groupMapReduce(_._1)(_._2)(_ + _)

object Polymer:
  def parse(input: Seq[String]): Polymer = {
    val pairs = input.head.toSeq.sliding(2).map { case Seq(left, right) => Pair(left, right) }
    val rules = InsertionRules.parse(input.drop(2))

    Polymer(
      pairCounts = pairs.toSeq.groupMapReduce(identity)(_ => 1L)(_ + _),
      rules = rules
    )
  }
