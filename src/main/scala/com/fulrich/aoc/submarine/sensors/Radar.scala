package com.fulrich.aoc.submarine.sensors

import com.fulrich.aoc.input.PuzzleInput

class Radar:
  def countIncreasingDepths(depths: PuzzleInput, windowSize: Int = 1): Int = 
    depths.toInt.sliding(windowSize).sliding(2).count {
      case Seq(depths1, depths2) => depths2.last > depths1.head
    }