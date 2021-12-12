package com.fulrich.aoc.submarine.window.octopuses

import com.fulrich.aoc.algebra._
import scala.collection.immutable.Stream.Cons
import io.AnsiColor._
import scala.annotation.tailrec

case class Consortium(octopuses: Grid[Octopus]):
  lazy val flashes: Int = octopuses.values.map(_.flashes).sum

  def synchronizationStep(count: Int = 1, grid: Grid[Octopus] = octopuses): Int = {
    val nextStep = observe(grid.keys, grid)
    if nextStep.values.map(_.energy).filterNot(_ == 0).isEmpty then count else synchronizationStep(count + 1, nextStep)
  }

  def observeOver(cycles: Int): Consortium  = Iterator.iterate(this)(_.observe).drop(cycles).next

  def observe: Consortium = Consortium(observe(octopuses.keys,  octopuses))

  @tailrec
  private final def observe(toEnergize: Seq[Coordinate], grid: Grid[Octopus]): Grid[Octopus] = {
    val energizations = grid.transformAt(toEnergize)(_.energize)
    val flashedOctopus = energizations.values.filter(_.justFlashed)

    if flashedOctopus.isEmpty then energizations.mapValues(_.resetFlash)
    else observe(flashedOctopus.flatMap(_.at.surrounding), energizations.mapValues(_.completeFlash))
  }

  def print(grid: Grid[Octopus] = octopuses): Unit = grid.print { value => value match {
    case Storing(at, 0, _) => s"${GREEN}9  ${RESET}"
    case Storing(at, 9, _) => s"${CYAN}9  ${RESET}"
    case Storing(at, energy, _) => energy.toString.padTo(3, ' ')
    case JustFlashed(at, energy, _) => s"${YELLOW}${energy.toString.padTo(3, ' ')}${RESET}"
    case Flashed(at, energy, _) => s"${RED}${energy.toString.padTo(3, ' ')}${RESET}"
  } }

object Consortium:
  def parse(input: Seq[String]): Consortium = Consortium(
    Grid.parse(input) { case (coordinate, value) => Storing(coordinate, value.asDigit, 0) }
  )
