package com.fulrich.aoc.submarine.helm.navigation.subterranean

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class PathTest extends AnyFunSuite with LoneElement:
  test("A path cannot return to the cave it came from") {
    Path.start.unavailableCaves should contain (Start)
  }

  test("next paths will be empty if no valid paths remain") {
    Path.start.next(Seq(Start)) shouldBe empty
  }

  test("When creating the next possible path steps unavailable caves are omitted") {
    val nextPaths = Path.start.next(Seq(Start, Cave("A")))

    nextPaths.loneElement shouldBe Path(Seq(Start, Cave("A")))
  }

  test("Cannot go to a path with a maximum limit if it has been surpassed") {
    val path = Path.start + Cave("A")

    path.next(Seq(Start)) shouldBe empty
  }

  test("Can add a cave to the end of the path") {
    (Path.start + Cave("B")) shouldBe Path(Seq(Start, Cave("B")))
  }

  test("If a cave is large it is never unavailable") {
    val largeCave = Cave("A")
    val otherCave = Cave("B")

    (Path.start + largeCave + largeCave + otherCave).unavailableCaves should not contain largeCave
  }

  test("Path is considered complete if it reached the end") {
    Path.start.isComplete shouldBe false
    (Path.start + End).isComplete shouldBe true
  }
