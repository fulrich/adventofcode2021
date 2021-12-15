package com.fulrich.aoc.submarine.sensors.thermals

import com.fulrich.aoc.algebra._


case class CameraCode(grid: Grid[Boolean], folds: Seq[FoldInstruction]):
  def toString(color: String = "", reset: String = ""): String = 
    grid.toString(value => if value then s"${color}#${reset}" else ".")

  def print: Unit = println(toString)

  lazy val visibleDots = grid.values.count(_ == true)

  def fold(count: Int = folds.length): CameraCode = 
    folds.take(count).foldLeft(this) { case (cameraCode, instruction) => instruction match {
      case Horzontal(row) => cameraCode.foldHorizontal(row)
      case Vertical(column) => cameraCode.foldVertical(column)
    } }

  def foldHorizontal(row: Int): CameraCode = copy(
    grid = grid.splitOnRow(row, true).toList.reduce((top, bottom) => top.merge(bottom.flipHorizontal)(_ || _))
  )

  def foldVertical(column: Int): CameraCode = copy(
    grid = grid.splitOnColumn(column, true).toList.reduce((top, bottom) => top.merge(bottom.flipVertical)(_ || _))
  )

object CameraCode:
  def apply(input: Seq[String]): CameraCode = {
    val coordinates: Seq[String] = input.takeWhile(_.nonEmpty)
    val folds = input.takeRight(input.length - coordinates.length - 1)

    CameraCode(
      grid = Grid.fromCoordinates(coordinates, default = false)(_ => true),
      folds = folds.filter(_.nonEmpty).map(FoldInstruction.parse)
    )
  }
