package com.fulrich.aoc

import input._
import com.fulrich.aoc.input.Serialization.given
import submarine.Submarine
import submarine.helm.HelmCommand

object Main:
  def main(args: Array[String]): Unit = {
    new cli.Configuration(args).selection match {
      case selection: AocPuzzle => solve(selection)
      case selection: SubmarineCommand => println(submarine(selection))
      case Unknown => println("An unknown entry was found.")
    }
  }

  def submarine(selection: SubmarineCommand, submarine: Submarine = Submarine()): Submarine = selection match {
    case SubmarineCommand("navigate", input) => submarine.navigate(input)
    case _ => submarine
  }

  def solve(selection: AocPuzzle): Unit = selection match {
    case AocPuzzle(1, 1, input) => println(Submarine().radar.depthScan(input))
    case AocPuzzle(1, 2, input) => println(Submarine().radar.depthScan(input))
    case AocPuzzle(2, 1, input) => println(Submarine().navigate(input))
    case AocPuzzle(2, 2, input) => {
      val position = Submarine().navigate(input).position
      println(position.horizontal * position.depth)
    }
    case AocPuzzle(3, 1, input) => println(Submarine().diagnose(input).power.consumption)
    case AocPuzzle(3, 2, input) => println(Submarine().diagnose(input).lifeSupport.rating)
    case _ => println(s"No solution exists for Day ${selection.day} - Part ${selection.part}.")
  }
