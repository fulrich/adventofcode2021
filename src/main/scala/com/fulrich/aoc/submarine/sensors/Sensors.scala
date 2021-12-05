package com.fulrich.aoc.submarine.sensors

import vents.Vent
import radar.Radar

class Sensors:
  def radar: Radar = new Radar
  def vents(input: Seq[String]): Vent = Vent(input)
