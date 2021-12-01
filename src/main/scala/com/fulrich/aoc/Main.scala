package com.fulrich.aoc

import input._

object Main:
  def main(args: Array[String]): Unit = {
    val configuration = new cli.Configuration(args)
    val puzzleSelection = configuration.puzzleSelection
    val puzzleInput = PuzzleInput.fromInputRequest(configuration.inputRequest)

    solve(puzzleSelection, puzzleInput)
  }

  def solve(selection: PuzzleSelection, input: PuzzleInput): Unit = selection match {
    case PuzzleSelection(1, 1) => println(submarine.Radar.countIncreasingDepths(input))
    case PuzzleSelection(1, 2) => println(submarine.Radar.countIncreasingDepths(input, windowSize = 3))
    case _ => println(s"No solution exists for Day ${selection.day} - Part ${selection.part}.")
  }
