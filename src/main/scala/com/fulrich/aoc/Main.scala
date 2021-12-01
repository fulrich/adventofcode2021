package com.fulrich.aoc

import input.PuzzleInput

object Main:
  def main(args: Array[String]): Unit = {
    val configuration = new cli.Configuration(args)
    PuzzleInput.fromInputRequest(configuration.inputRequest).raw.foreach(println)
  }
