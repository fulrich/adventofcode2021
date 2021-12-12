package com.fulrich.aoc.algebra

case class Grid[A](private val points: Map[Coordinate, A]):
  def at(x: Int, y: Int): Option[A] = at(Coordinate(x, y))
  def at(coordinate: Coordinate): Option[A] = points.get(coordinate)

  def contains(key: Coordinate): Boolean = points.contains(key)

  lazy val keys: Seq[Coordinate] = points.keys.toSeq
  lazy val values: Seq[A] = points.values.toSeq

  def mapValues[B](f: A => B): Grid[B] = Grid(points.mapValues(f).toMap)

  def transformAt(positions: Seq[Coordinate])(f: A => A): Grid[A] = 
    if positions.isEmpty then this 
    else Grid(
      positions.foldLeft(points) { case (accumulation, key) => accumulation.get(key) match {
        case Some(value) => accumulation.updated(key, f(value))
        case None => accumulation
      } }
    )

  def print(toString: A => String, default: String = " "): Unit = {
    val maximumY = keys.map(_.y).max

    for (y <- 0 to maximumY) {
      println(keys.filter(_.y == y).sortBy(_.x).map(coord => at(coord).map(toString).getOrElse(default)).mkString)
    }
  }

object Grid:
  def parse[A](input: Seq[String])(parser: (Coordinate, Char) => A): Grid[A] = Grid(
    input.zipWithIndex.flatMap { (row, y) =>
      row.toSeq.zipWithIndex.map { (value, x) =>
        Coordinate(x, y) -> parser(Coordinate(x, y), value)
      }
    }.toMap
  )
