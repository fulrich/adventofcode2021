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

  def submarine(submarine: Submarine)(implicit selection: SubmarineCommand): SubmarineResult[_] = selection match {
    case SubmarineCommand("navigate", input) => submarine.navigate(input)
    case _ => submarine
  }

  def solve(submarine: Submarine)(implicit selection: AocPuzzle): AocPuzzleResult[_] = selection match {
    case AocPuzzle(1, 1, input) => submarine.radar.depthScan(input)
    case AocPuzzle(1, 2, input) => submarine.radar.depthScan(input)
    case AocPuzzle(2, 1, input) => submarine.navigate(input)
    case AocPuzzle(2, 2, input) => submarine.navigate(input).position.calculate
    case AocPuzzle(3, 1, input) => submarine.diagnose(input).power.consumption
    case AocPuzzle(3, 2, input) => submarine.diagnose(input).lifeSupport.rating
    case AocPuzzle(4, 1, input) => submarine.entertainmentSystem.bingo(input).play().score
    case AocPuzzle(4, 2, input) => submarine.entertainmentSystem.bingo(input).playToLose().score
    case _ => s"No solution exists for Day ${selection.day} - Part ${selection.part}."
  }
