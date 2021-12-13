package com.fulrich.aoc.submarine.helm.navigation.subterranean

import scala.annotation.tailrec

case class PathFinding(connections: Connections):
  def paths: Seq[Path] = {
    val initalConnections = connections.from(Start).map { firstCave =>
      Path.start + firstCave
    }

    paths(initalConnections, Seq.empty)
  }

  @tailrec
  private final def paths(current: Seq[Path], complete: Seq[Path]): Seq[Path] = {
    val next = current.flatMap { path => path.next(connections.from(path.last)) }
    val (justCompleted, continuing) = next.partition(_.isComplete)

    if continuing.isEmpty then complete ++ justCompleted 
    else paths(continuing, complete ++ justCompleted)
  }

object PathFinding:
  def apply(input: Seq[String]): PathFinding = PathFinding(Connections.parse(input))