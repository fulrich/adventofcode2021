package com.fulrich.aoc.submarine.sensors.probes

import com.fulrich.aoc.algebra.Coordinate

case class Trajectory(path: Seq[Coordinate], initialVelocity: Velocity, velocity: Velocity):
  def moving(newVelocity: Velocity): Trajectory = copy(initialVelocity = newVelocity, velocity = newVelocity)

  lazy val apex: Int = path.map(_.y).max
  lazy val at: Coordinate = path.last

  lazy val next: Trajectory = copy(
    path = path :+ at.copy(x = at.x + velocity.x, y = at.y + velocity.y), 
    velocity = velocity.drag
  )


object Trajectory:
  def start(origin: Coordinate): Trajectory = Trajectory(Seq(origin), Velocity.still, Velocity.still)
