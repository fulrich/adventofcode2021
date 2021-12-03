package com.fulrich.aoc.submarine

import com.fulrich.aoc.input.PuzzleInput
import sensors._
import helm._
import diagnostics._


case class Submarine(
    position: Position = Position.origin,
    radar: Radar = new Radar,
    helm: Helm = new Helm):
  
  def navigate(commands: PuzzleInput): Submarine = copy(position = helm.navigate(commands, position))

  def depthScan(depths: PuzzleInput): Int = radar.countIncreasingDepths(depths)

  def diagnose(diagnosticData: PuzzleInput): Diagnostics = Diagnostics(diagnosticData.raw)