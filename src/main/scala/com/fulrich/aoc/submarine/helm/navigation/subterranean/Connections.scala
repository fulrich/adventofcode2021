package com.fulrich.aoc.submarine.helm.navigation.subterranean

case class Connections(all: Seq[Connection]):
  lazy val allCaves = all.flatMap { connection => Seq(connection.start, connection.end) }.distinct
  val mapping: Map[Cave, Seq[Cave]] = allCaves.map { cave =>
    cave -> (all.filter(_.start == cave).map(_.end) ++ all.filter(_.end == cave).map(_.start)).distinct
  }.toMap

  def from(cave: Cave): Seq[Cave] =  mapping.get(cave).getOrElse(Seq.empty)

object Connections:
  def parse(input: Seq[String]): Connections = Connections(input.map(Connection.apply))
