package com.fulrich.aoc.submarine

import sensors._
import helm._
import diagnostics._


case class Submarine(
    position: Position = Position.origin,
    radar: Radar = new Radar,
    helm: Helm = new Helm):
  
  def navigate(commands: Seq[HelmCommand]): Submarine = copy(position = helm.navigate(commands, position))

  def diagnose(diagnosticData: DiagnosticData): Diagnostics = Diagnostics(diagnosticData)