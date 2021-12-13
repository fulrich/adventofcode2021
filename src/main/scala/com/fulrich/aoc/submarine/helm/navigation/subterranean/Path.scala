package com.fulrich.aoc.submarine.helm.navigation.subterranean

case class Path(pathing: Seq[Cave]):
  val isComplete: Boolean = pathing.lastOption.contains(End)
  lazy val last: Cave = pathing.last

  def +(next: Cave): Path = copy(pathing = pathing :+ next)

  def next(possibleCaves: Seq[Cave]): Seq[Path] =
    possibleCaves.flatMap { possibleNext =>
      if canVisit(possibleNext) then Some(this + possibleNext) else None
    }

  def canVisit(cave: Cave): Boolean = !unavailableCaves.contains(cave)

  lazy val unavailableCaves: Seq[Cave] = {
    val visitedSmalls = pathing.filter(_.isSmall)
    val distinctSmalls = visitedSmalls.distinct

    if visitedSmalls.length == distinctSmalls.length then Seq(Start, pathing.last)
    else distinctSmalls :+ last :+ Start
  }
  
  override def toString: String = pathing.mkString("-")

object Path:
  val start = Path(Seq(Start))
