package com.fulrich.aoc

import input._
import com.fulrich.aoc.input.Serialization.given
import submarine.Submarine
import submarine.helm.HelmCommand
import output._

object Main:
  def main(args: Array[String]): Unit = {
    val result = new cli.Configuration(args).selection match {
      case selection: AocPuzzle => solve(Submarine())(selection)
      case selection: SubmarineCommand => submarine(Submarine())(selection)
      case Unknown => UnknownResult("An unknown entry was found.")
    }

    result.output
  }

  def submarine(submarine: Submarine)(implicit selection: SubmarineCommand): ExecutionResult[Submarine] = selection match {
    case SubmarineCommand("navigate", input) => SubmarineResult[Submarine](submarine.navigate(input))
    case _ => SubmarineResult(submarine)
  }

  def solve(submarine: Submarine)(implicit selection: AocPuzzle): ExecutionResult[Any] = selection match {
    case AocPuzzle(1, 1, input) => AocPuzzleResult(submarine.radar.depthScan(input))
    case AocPuzzle(1, 2, input) => AocPuzzleResult(submarine.radar.depthScan(input))
    case AocPuzzle(2, 1, input) => AocPuzzleResult(submarine.navigate(input))
    case AocPuzzle(2, 2, input) => AocPuzzleResult(submarine.navigate(input).position.calculate)
    case AocPuzzle(3, 1, input) => AocPuzzleResult(submarine.diagnose(input).power.consumption)
    case AocPuzzle(3, 2, input) => AocPuzzleResult(submarine.diagnose(input).lifeSupport.rating)
    case AocPuzzle(4, 1, input) => AocPuzzleResult(submarine.entertainmentSystem.bingo(input).play().score)
    case AocPuzzle(4, 2, input) => AocPuzzleResult(submarine.entertainmentSystem.bingo(input).playToLose().score)
    case _ => AocPuzzleResult(s"No solution exists for Day ${selection.day} - Part ${selection.part}.")
  }
