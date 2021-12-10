package com.fulrich.aoc.submarine.sensors

import vents.Vent
import radar.Radar
import heightmap.Heightmap

class Sensors:
  def radar: Radar = new Radar
  def vents(input: Seq[String]): Vent = Vent(input)
  def heatmap(input: Seq[String]): Heightmap = Heightmap.parse(input)
