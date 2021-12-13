package com.fulrich.aoc.submarine.helm.navigation.subterranean

sealed trait Cave(val identifier: String):
  def isSmall: Boolean = false

case object Start extends Cave("start")

case object End extends Cave("end")

case class LargeCave(override val identifier: String) extends Cave(identifier)

case class SmallCave(override val identifier: String) extends Cave(identifier):
  override def isSmall: Boolean = true

object Cave:
  def apply(identifier: String): Cave = identifier match {
    case Start.identifier => Start
    case End.identifier => End
    case smallCave if smallCave.exists(_.isLower) => SmallCave(identifier)
    case largeCave if largeCave.exists(_.isUpper) => LargeCave(identifier)
  }
