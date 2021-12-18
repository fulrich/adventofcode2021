package com.fulrich.aoc.submarine.communications.processing

import com.fulrich.aoc.submarine.communications._

case class Raw(current: String, full: String):
  def +(digit: Char): Raw = copy(current = current + digit, full = full + digit)
  
  def length: Int = current.length
  def isEmpty: Boolean = current.isEmpty

  def head: Char = current.head
  def tail: Raw = copy(current = current.tail)

  def lift(index: Int): Option[Char] = current.lift(index)

  def drop(n: Int): Raw = copy(current = current.drop(n))
  def take(n: Int): String = current.take(n)

  def grouped(n: Int): Iterator[String] = current.grouped(n)

object Raw:
  val empty = Raw("")

  def apply(initial: String): Raw = Raw(initial, initial)
