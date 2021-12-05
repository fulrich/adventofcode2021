package com.fulrich.aoc.output

import com.fulrich.aoc.submarine.Submarine

trait Serialization[A]:
  def serialize(output: A): String

object Serialization:
  given Serialization[String] with
    def serialize(value: String): String = value

  given Serialization[Int] with
    def serialize(value: Int): String = value.toString

  given Serialization[Submarine] with
    def serialize(value: Submarine): String = {
      s"""
        |Submarine
        |  Depth: ${value.position.depth}
        |  Forward: ${value.position.horizontal}
      """.stripMargin
    }