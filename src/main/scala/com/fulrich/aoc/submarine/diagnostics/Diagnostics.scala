package com.fulrich.aoc.submarine.diagnostics

import com.fulrich.aoc.submarine.diagnostics.power.Power
import com.fulrich.aoc.submarine.diagnostics.lifesupport.LifeSupport

case class Diagnostics(
  power: Power = Power.empty,
  lifeSupport: LifeSupport = LifeSupport.empty
)

object Diagnostics:
  def apply(data: DiagnosticData): Diagnostics = 
    Diagnostics(
      power = Power(data),
      lifeSupport = LifeSupport(data)
    )