package com.fulrich.aoc.input

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.FileTesting

class PuzzleInputTest extends AnyFunSuite with FileTesting:
  val test_resource_source = Vector(
    "Testing Resources!",
    "Multiline Output!"
  )

  test("Can create a puzzle input from a list of strings") {
    val rawStrings = Vector("1", "2", "3")

    PuzzleInput(rawStrings).raw shouldBe rawStrings
  }

  test("Can create a puzzle input from a variable list of strings") {
    PuzzleInput("1", "2", "3").raw shouldBe Vector("1", "2", "3")
  }

  test("Can create a puzzle input from a ResourceRequest") {
    val resourceReqeust = ResourceRequest("test_resource")

    PuzzleInput.fromInputRequest(resourceReqeust).raw shouldBe test_resource_source
  }

  test("Can create a puzzle input from FileRequest") {
    withFile(test_resource_source) { file =>
      val fileRequest = FileRequest(file)

      PuzzleInput.fromInputRequest(fileRequest).raw shouldBe test_resource_source
    }
  }