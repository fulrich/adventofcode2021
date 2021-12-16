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
    case AocPuzzle(8, 1, input) => submarine.displays(input).countDigits(1, 4, 7, 8)
    case AocPuzzle(8, 2, input) => submarine.displays(input).total
    case AocPuzzle(9, 1, input) => submarine.sensors.heatmap(input).lowPointsRisk
    case AocPuzzle(9, 2, input) => submarine.sensors.heatmap(input).areaOfLargestBasins(numberOfBasins = 3)
    case AocPuzzle(10, 1, input) => submarine.helm.navigation.validateSyntax(input).validationScore
    case AocPuzzle(10, 2, input) => submarine.helm.navigation.validateSyntax(input).autoCompleteScore
    case AocPuzzle(11, 1, input) => submarine.window.octopuses(input).observeOver(100).flashes
    case AocPuzzle(11, 2, input) => submarine.window.octopuses(input).synchronizationStep()
    case AocPuzzle(12, _, input) => submarine.helm.navigation.subterraneanScan(input).paths.length
    case AocPuzzle(13, 1, input) => submarine.sensors.thermalCamera(input).fold(1).visibleDots
    case AocPuzzle(13, 2, input) => submarine.sensors.thermalCamera(input).fold()
    case AocPuzzle(14, 1, input) => submarine.hull.polymerization(input).steps(10).commonalityDifference
    case AocPuzzle(14, 2, input) => submarine.hull.polymerization(input).steps(40).commonalityDifference
    case AocPuzzle(15, 1, input) => submarine.sensors.caves(input).lowestRisk
    case AocPuzzle(15, 2, input) => submarine.sensors.caves(input).increaseGrid(5).lowestRisk
    case _ => s"No solution exists for Day ${selection.day} - Part ${selection.part}."
  }
