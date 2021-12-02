package com.fulrich.aoc

import input._
import submarine.Submarine

object Main:
  def main(args: Array[String]): Unit = {
    val configuration = new cli.Configuration(args)
    val puzzleSelection = configuration.puzzleSelection
    val puzzleInput = PuzzleInput.fromInputRequest(configuration.inputRequest)

    solve(puzzleSelection, puzzleInput)
  }

  def solve(selection: PuzzleSelection, input: PuzzleInput): Unit = selection match {
    case PuzzleSelection(1, 1) => println(Submarine().depthScan(input))
    case PuzzleSelection(1, 2) => println(Submarine().depthScan(input))
    case PuzzleSelection(2, 1) => println(Submarine().navigate(input))
    case PuzzleSelection(2, 2) => {
      val position = Submarine().navigate(input).position
      println(position.horizontal * position.depth)
    }
    case _ => println(s"No solution exists for Day ${selection.day} - Part ${selection.part}.")
  }
