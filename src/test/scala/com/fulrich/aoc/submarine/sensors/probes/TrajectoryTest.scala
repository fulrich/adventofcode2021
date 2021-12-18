package com.fulrich.aoc.submarine.sensors.probes

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

import com.fulrich.aoc.algebra.Coordinate

class TrajectoryTest extends AnyFunSuite:
  
  test("Trajectory can follow along the path") {
    val velocity = Velocity(7, 2)
    val trajectory = Trajectory.start(Coordinate.origin).moving(velocity)
    val target = TargetArea(xRange = (20, 30), yRange = (-10, -5))

    val first = trajectory.next
    first.at shouldBe Coordinate(7 ,2)

    val second = first.next
    second.at shouldBe Coordinate(13 ,3)

    val third = second.next
    third.at shouldBe Coordinate(18 ,3)

    val fourth = third.next
    fourth.at shouldBe Coordinate(22 ,2)

    val fifth = fourth.next
    fifth.at shouldBe Coordinate(25 ,0)

    val sixth = fifth.next
    sixth.at shouldBe Coordinate(27 ,-3)

    val seventh = sixth.next
    seventh.at shouldBe Coordinate(28 ,-7)
    seventh.apex shouldBe 3
    seventh.initialVelocity shouldBe velocity
  }
