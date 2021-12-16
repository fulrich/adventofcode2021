package com.fulrich.aoc.submarine.sensors

import vents.Vent
import radar.Radar
import heightmap.Heightmap
import thermals.CameraCode
import caves.ChitonDensity

class Sensors:
  def radar: Radar = new Radar
  def vents(input: Seq[String]): Vent = Vent(input)
  def heatmap(input: Seq[String]): Heightmap = Heightmap.parse(input)
  def thermalCamera(input: Seq[String]): CameraCode = CameraCode(input)
  def caves(input: Seq[String]): ChitonDensity = ChitonDensity.parse(input)
