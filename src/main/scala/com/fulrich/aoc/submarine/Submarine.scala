package com.fulrich.aoc.submarine

import sensors._
import helm._
import diagnostics._
import entertainment._


case class Submarine(
    position: Position = Position.origin,
    sensors: Sensors = new Sensors,
    helm: Helm = new Helm,
    entertainmentSystem: EntertainmentSystem = new EntertainmentSystem):
  
  def navigate(commands: Seq[HelmCommand]): Submarine = copy(position = helm.navigate(commands, position))

  def diagnose(diagnosticData: DiagnosticData): Diagnostics = Diagnostics(diagnosticData)