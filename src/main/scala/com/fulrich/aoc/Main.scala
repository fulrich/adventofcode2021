package com.fulrich.aoc

import input._
import com.fulrich.aoc.input.Serialization.given
import submarine.Submarine
import submarine.helm.HelmCommand
import output._

object Main:
  def main(args: Array[String]): Unit = {
    val result = new cli.Configuration(args).selection match {
      case selection: AocPuzzle => solve(selection)
      case selection: SubmarineCommand => submarine(selection)
      case Unknown => UnknownResult("An unknown entry was found.")
    }

    result.output
  }

  def submarine(selection: SubmarineCommand, submarine: Submarine = Submarine()): ExecutionResult[Submarine] = selection match {
    case SubmarineCommand("navigate", input) => SubmarineResult[Submarine](submarine.navigate(input), selection)
    case _ => SubmarineResult(submarine, selection)
  }

  def solve(selection: AocPuzzle, submarine: Submarine = Submarine()): ExecutionResult[Any] = selection match {
    case AocPuzzle(1, 1, input) => AocPuzzleResult(submarine.radar.depthScan(input), selection)
    case AocPuzzle(1, 2, input) => AocPuzzleResult(submarine.radar.depthScan(input), selection)
    case AocPuzzle(2, 1, input) => AocPuzzleResult(submarine.navigate(input), selection)
    case AocPuzzle(2, 2, input) => {
      val position = submarine.navigate(input).position
      AocPuzzleResult(position.horizontal * position.depth, selection)
    }
    case AocPuzzle(3, 1, input) => AocPuzzleResult(submarine.diagnose(input).power.consumption, selection)
    case AocPuzzle(3, 2, input) => AocPuzzleResult(submarine.diagnose(input).lifeSupport.rating, selection)
    case AocPuzzle(4, 1, input) => AocPuzzleResult(submarine.entertainmentSystem.bingo(input).play().score, selection)
    case AocPuzzle(4, 2, input) => AocPuzzleResult(submarine.entertainmentSystem.bingo(input).playToLose().score, selection)
    case _ => AocPuzzleResult(s"No solution exists for Day ${selection.day} - Part ${selection.part}.", selection)
  }
