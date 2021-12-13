package com.fulrich.aoc.submarine.helm.navigation

import syntax.Syntax
import subterranean.PathFinding

class NavigationSystem:
  def validateSyntax(input: Seq[String]): Syntax = Syntax.validate(input)
  def subterraneanScan(input: Seq[String]): PathFinding = PathFinding(input)
