package com.fulrich.aoc.submarine.sensors.probes

object Launcher:
  def probeWithHighestApex(area: TargetArea): Probe =
    (xMinimum(area) to xMaximum(area)).flatMap { startX =>
      // println("Complete All Y for X: " + startX)
      (yMinimum(area) to yMaximum(area)).flatMap { startY =>
        val probe = Probe.fromOrigin.aim(at = area).fire(Velocity(startX, startY))
        if probe.hitArea then Some(probe) else None
      }
    }.maxBy(_.apex)

  def totalPossibleVelocities(area: TargetArea): Int =
    (xMinimum(area) to xMaximum(area)).flatMap { startX =>
      // println("Complete All Y for X: " + startX)
      (yMinimum(area) to yMaximum(area)).flatMap { startY =>
        val probe = Probe.fromOrigin.aim(at = area).fire(Velocity(startX, startY))
        if probe.hitArea then Some(probe) else None
      }
    }.length
  
  def yMinimum(area: TargetArea) = area.minimum.y
  def yMaximum(area: TargetArea) = Math.abs(area.minimum.y) + 1
  def xMinimum(area: TargetArea) = area.minimum.x.min(area.maximum.x).min(0)
  def xMaximum(area: TargetArea) = area.minimum.x.max(area.maximum.x).max(0)
