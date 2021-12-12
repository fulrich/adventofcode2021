package com.fulrich.aoc.submarine.window

import lanternfish.School
import crabs.Swarm
import octopuses.Consortium

class Window:
  def lanternfish(fish: String): School = School.parse(fish)
  def crabs(crabs: String): Swarm = Swarm.parse(crabs)
  def octopuses(octopuses: Seq[String]): Consortium = Consortium.parse(octopuses)
