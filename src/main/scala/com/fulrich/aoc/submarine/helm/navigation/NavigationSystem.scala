package com.fulrich.aoc.submarine.helm.navigation

import syntax.Syntax

class NavigationSystem:
  def validateSyntax(input: Seq[String]): Syntax = Syntax.validate(input)
