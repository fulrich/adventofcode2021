package com.fulrich.aoc

import input.PuzzleInput

object Main:
  def main(args: Array[String]): Unit = {
    val configuration = new CommandLineConfig(args)
    PuzzleInput.fromConfiguration(configuration).raw.foreach(println)
  }
