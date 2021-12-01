package com.fulrich.aoc.submarine

import com.fulrich.aoc.input.PuzzleInput

object Radar:
  def countIncreasingDepths(depths: PuzzleInput, windowSize: Int = 1): Int = 
    depths.toInt.sliding(windowSize).sliding(2).count {
      case Seq(depths1, depths2) => depths2.sum > depths1.sum
    }
