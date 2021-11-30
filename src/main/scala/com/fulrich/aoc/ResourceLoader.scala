package com.fulrich.aoc

import scala.io.Source

object ResourceLoader {
  def asLines[A](resource: String): Vector[String] =
    Source.fromResource(resource).getLines.toVector
}