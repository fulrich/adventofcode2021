package com.fulrich.aoc.submarine

import com.fulrich.aoc.input.PuzzleInput

object Radar:
  def increasingDepthWindows(depths: PuzzleInput, windowSize: Int = 3): Int =
    depths.toInt.map(_.toInt).sliding(windowSize).sliding(2).count {
      case Seq(window1, window2) => window2.sum > window1.sum
    }

  def increasingDepths(depths: PuzzleInput): Int = 
    depths.toInt.sliding(2).count {
      case Seq(depth1, depth2) => depth2 > depth1
    }
