package com.fulrich.aoc.cli

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.FileTesting
import com.fulrich.aoc.input._

class ConfigurationTest extends AnyFunSuite with Inside with FileTesting:
  test("Calling the puzzle subcommand will create an AocPuzzle selection") {
    val config = configuration("puzzle", "--day", "3", "--part", "2")
    
    config.selection shouldBe a [AocPuzzle]
    inside(config.selection) { case selection: AocPuzzle =>
      selection.day shouldBe 3
      selection.part shouldBe 2
    }
  }

  test("Calling the submarine subcommand will create an SubmarineCommand selection") {
    val config = configuration("submarine", "navigate", "--resource", "day_1")

    config.selection shouldBe a [SubmarineCommand]
    inside(config.selection) { case selection: SubmarineCommand =>
      selection.command shouldBe "navigate"
    }
  }

  def configuration(arguments: String*): Configuration = 
    new Configuration(arguments.toArray)