package com.fulrich.aoc.cli

import org.rogach.scallop._
import com.fulrich.aoc.input._
import com.fulrich.aoc.ExecutionSelecting
import com.fulrich.aoc.AocDefaults

class SubmarineSubcommand(aocDefaults: AocDefaults = new AocDefaults) extends Subcommand("submarine") with ExecutionSelecting {  
  object Navigate extends Subcommand("navigate") with InputConfiguration(aocDefaults) {
    descr("Use this command to navigate the Submarine to a new position.")
  }

  addSubcommand(Navigate)
  def selection: ExecutionSelection = subcommand match {
    case Some(Navigate) => SubmarineCommand("navigate", DataInput(Navigate.inputRequest()))
    case _ => Unknown
  }
}