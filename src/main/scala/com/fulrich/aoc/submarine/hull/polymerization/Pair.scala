package com.fulrich.aoc.submarine.hull.polymerization

case class Pair(left: Char, right: Char):
  override def toString: String = left.toString + right.toString

object Pair:
  def apply(input: String): Pair = input.toSeq match {
    case Seq(left, right) => Pair(left, right)
  }
