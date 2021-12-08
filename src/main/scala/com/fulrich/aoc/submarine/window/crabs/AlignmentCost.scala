package com.fulrich.aoc.submarine.window.crabs

case class AlignmentCost(position: Int, fuel: Int):
  def +(movement: Int): AlignmentCost = copy(fuel = fuel + AlignmentCost.fuelRequired(movement))
  

object AlignmentCost:
  def at(position: Int): AlignmentCost = AlignmentCost(position = position, fuel = 0)
  def fuelRequired(movement: Int): Int = ((movement / 2D) * (1 + movement)).toInt