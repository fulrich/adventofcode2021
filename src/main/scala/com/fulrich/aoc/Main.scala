package com.fulrich.aoc

import input._
import com.fulrich.aoc.input.Deserialization.given
import com.fulrich.aoc.output.Serialization.given
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
    case AocPuzzle(1, _, input) => submarine.sensors.radar.depthScan(input)
    case AocPuzzle(2, _, input) => submarine.navigate(input).position.calculate
    case AocPuzzle(3, 1, input) => submarine.diagnose(input).power.consumption
    case AocPuzzle(3, 2, input) => submarine.diagnose(input).lifeSupport.rating
    case AocPuzzle(4, 1, input) => submarine.entertainmentSystem.bingo(input).play().score
    case AocPuzzle(4, 2, input) => submarine.entertainmentSystem.bingo(input).playToLose().score
    case AocPuzzle(5, _, input) => submarine.sensors.vents(input).intersectionsOver(2).length
    case AocPuzzle(6, 1, input) => submarine.window.lanternfish(input.raw.head).observeOver(80).totalFish
    case AocPuzzle(6, 2, input) => submarine.window.lanternfish(input.raw.head).observeOver(256).totalFish
    case AocPuzzle(7, _, input) => submarine.window.crabs(input.raw.head).cheapestAlignment.fuel
    case _ => s"No solution exists for Day ${selection.day} - Part ${selection.part}."
  }
