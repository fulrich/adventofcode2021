package com.fulrich.aoc.submarine.helm.navigation.subterranean

case class Connection(start: Cave, end: Cave)

object Connection:
  def apply(input: String): Connection = input.split('-') match {
    case Array(start: String, end: String) => Connection(Cave(start), Cave(end))
  }
