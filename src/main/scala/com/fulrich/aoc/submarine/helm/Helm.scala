package com.fulrich.aoc.submarine.helm

import com.fulrich.aoc.submarine.Position
import navigation.NavigationSystem

class Helm(val navigation: NavigationSystem = new NavigationSystem):
  def navigate(commandList: Seq[HelmCommand], position: Position): Position =
    commandList.foldLeft(position)(navigate)

  def navigate(position: Position, command: HelmCommand): Position = command match {
    case Forward(value) => position.copy(
      horizontal = position.horizontal + value, 
      depth = position.depth + (position.aim * value)
    )
    case Down(value) => position.copy(aim = position.aim + value)
    case Up(value) => position.copy(aim = position.aim - value)
  }
