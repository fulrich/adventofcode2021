package com.fulrich.aoc.submarine.hull

import com.fulrich.aoc.submarine.hull.polymerization.Polymer

class Hull:
  def polymerization(input: Seq[String]): Polymer = Polymer.parse(input)