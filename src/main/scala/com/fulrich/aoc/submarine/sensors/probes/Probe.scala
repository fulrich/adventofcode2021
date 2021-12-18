package com.fulrich.aoc.submarine.sensors.probes

import com.fulrich.aoc.algebra.Coordinate
import scala.annotation.tailrec

case class Probe(origin: Coordinate, trajectory: Trajectory, target: TargetArea):
  lazy val isComplete: Boolean = hitArea || missedArea
  lazy val hitArea: Boolean = target.within(trajectory.at)
  lazy val missedArea: Boolean = target.past(trajectory.at)

  lazy val apex = trajectory.apex
  lazy val velocity = trajectory.initialVelocity

  def aim(at: TargetArea): Probe = copy(target = at)
  def power(velocity: Velocity): Probe = copy(trajectory = trajectory.moving(velocity))
  def fire(velocity: Velocity): Probe = Probe.followTrajectory(power(velocity))
  
  def next: Probe = copy(trajectory = trajectory.next)

object Probe:
  val fromOrigin: Probe = from(Coordinate.origin)
  def from(origin: Coordinate): Probe = Probe(origin, Trajectory.start(origin), TargetArea.none)

  @tailrec
  def followTrajectory(probe: Probe): Probe = if probe.isComplete then probe else followTrajectory(probe.next)
