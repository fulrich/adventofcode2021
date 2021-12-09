package com.fulrich.aoc.submarine.displays

import scala.annotation.targetName

case class WireMapping(mapping: Map[Char, Char]):
  def apply(input: Char): Char = mapping(input)

object WireMapping:
  @targetName("tupleBuilder")
  def apply(mappings: (Char, Char)*): WireMapping  = WireMapping(mappings.toMap)

  def apply(patterns: Seq[String]): WireMapping = {
    lazy val a: Char = seven.diff(one).head
    lazy val b: Char = b_e.filterNot(_ == e).head
    lazy val c: Char = c_e.filterNot(_ == e).head
    lazy val d: Char = b_d.filterNot(_ == b).head
    lazy val e: Char = b_e.intersect(e_g).head
    lazy val f: Char = one.filterNot(_ == c).head
    lazy val g: Char = e_g.filterNot(_ == e).head

    lazy val b_d = four.diff(one)
    lazy val b_e = length5.flatten.groupMapReduce(identity)(_ => 1)(_ + _).filter { case(_, count) => count == 1 }.keys.toSeq
    lazy val e_g = eight.diff(four :+ a)
    lazy val c_e_d = length6.flatten.groupMapReduce(identity)(_ => 1)(_ + _).filter { case(_, count) => count == 2 }.keys.toSeq
    lazy val c_e = c_e_d.filterNot(_ == d)
    
    lazy val one: Seq[Char] = patterns.find(_.length == 2).getOrElse("").toSeq
    lazy val four: Seq[Char] = patterns.find(_.length == 4).getOrElse("").toSeq
    lazy val seven: Seq[Char] = patterns.find(_.length == 3).getOrElse("").toSeq
    lazy val eight: Seq[Char] = patterns.find(_.length == 7).getOrElse("").toSeq

    lazy val length5 = patterns.filter(_.length == 5)
    lazy val length6 = patterns.filter(_.length == 6)

    WireMapping(
      a -> 'a',
      b -> 'b',
      c -> 'c',
      d -> 'd',
      e -> 'e',
      f -> 'f',
      g -> 'g'
    )
  }
  
  def default: WireMapping = WireMapping(
    'a' -> 'a',
    'b' -> 'b',
    'c' -> 'c',
    'd' -> 'd',
    'e' -> 'e',
    'f' -> 'f',
    'g' -> 'g'
  )
