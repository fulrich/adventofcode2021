package com.fulrich.aoc.submarine

import sensors._
import helm._
import diagnostics._
import entertainment._
import window._
import com.fulrich.aoc.submarine.displays.Displays


case class Submarine(
    position: Position = Position.origin,
    sensors: Sensors = new Sensors,
    helm: Helm = new Helm,
    entertainmentSystem: EntertainmentSystem = new EntertainmentSystem,
    window: Window = new Window):
  
  def navigate(commands: Seq[HelmCommand]): Submarine = copy(position = helm.navigate(commands, position))

  def diagnose(diagnosticData: DiagnosticData): Diagnostics = Diagnostics(diagnosticData)

  def displays(displaySequence: Seq[String]): Displays = Displays.parse(displaySequence)