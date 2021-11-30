package com.fulrich.aoc

import org.rogach.scallop._

class CommandLineConfig(arguments: Seq[String]) extends ScallopConf(arguments) {
  val resource = opt[String](required = true, default = Some("default"))
  verify()
}