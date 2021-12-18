package com.fulrich.aoc.submarine.sensors.probes

case class Velocity(x: Int, y: Int):
  lazy val drag: Velocity = copy(x = xDrag, y = yDrag)

  private val xDrag: Int = if x == 0 then x else x + (-1 * x.sign)
  private val yDrag: Int = y - 1

object Velocity:
  val still: Velocity = Velocity(0, 0)
