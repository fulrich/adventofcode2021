package com.fulrich.aoc.submarine.window.octopuses

import com.fulrich.aoc.algebra.Coordinate

sealed trait Octopus:
  def at: Coordinate
  def energy: Int
  def flashes: Int

  def hasFlashed: Boolean
  def justFlashed: Boolean

  def energize: Octopus
  def completeFlash: Octopus = this
  def resetFlash: Octopus = this

case class Storing(override val at: Coordinate, override val energy: Int, override val  flashes: Int = 0) extends Octopus:
  val hasFlashed: Boolean = false
  val justFlashed: Boolean = false

  def energize: Octopus = energy + 1 match {
    case newEnergy if newEnergy < Octopus.EnergyFlashPoint => Storing(at, newEnergy, flashes)
    case _ => JustFlashed(at, energy + 1, flashes + 1)
  }

case class JustFlashed(override val at: Coordinate, override val energy: Int, override val flashes: Int = 0) extends Octopus:
  val hasFlashed: Boolean = true
  val justFlashed: Boolean = true

  def energize: Octopus = JustFlashed(at, energy + 1, flashes)
  override def completeFlash: Octopus = Flashed(at, energy, flashes)

case class Flashed(override val at: Coordinate, override val energy: Int, override val flashes: Int = 0) extends Octopus:
  val hasFlashed: Boolean = true
  val justFlashed: Boolean = false

  def energize: Octopus = copy(energy = energy + 1)
  override def resetFlash: Octopus = Storing(at, 0, flashes)


object Octopus:
  val EnergyFlashPoint: Int = 10
