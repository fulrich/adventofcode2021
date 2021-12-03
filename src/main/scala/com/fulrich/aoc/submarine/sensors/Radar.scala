package com.fulrich.aoc.submarine.sensors

class Radar:
  def depthScan(depths: Seq[Int], windowSize: Int = 1): Int = 
    depths.sliding(windowSize).sliding(2).count {
      case Seq(depths1, depths2) => depths2.last > depths1.head
    }
