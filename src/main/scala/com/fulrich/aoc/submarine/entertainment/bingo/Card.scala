package com.fulrich.aoc.submarine.entertainment.bingo

import scala.annotation.targetName

case class Card(numbers: Seq[Number], lastMark: Option[Number] = None, winningNumber: Option[Int] = None):
  lazy val winner: Boolean = winningNumber.isDefined
  lazy val score: Int = numbers.filter(_.unmarked).map(_.number).sum * winningNumber.getOrElse(0)

  def at(row: Int, column: Int): Number = at(Location(row, column))
  def at(location: Location): Number = numbers.find(_.isAt(location)).get

  def findIndex(number: Int): Option[Int] = Option(numbers.indexWhere(_.number == number)).filter(_ >= 0)

  def mark(drawn: Int): Card = findIndex(drawn).map(markAt).map(_.detectWinner).getOrElse(this)

  private def markAt(index: Int): Card = copy(
    numbers = numbers.updated(index, numbers(index).mark),
    lastMark = Some(numbers(index))
  )

  private def detectWinner: Card = 
    if justWon then copy(winningNumber = lastMark.map(_.number)) else this

  private lazy val justWon: Boolean = lastMark.map(_.at).map { location =>
    checkLine(_.at.row == location.row) || checkLine(_.at.column == location.column)
  }.getOrElse(false)

  private def checkLine(filter: Number => Boolean): Boolean = 
    numbers.filter(filter).map(_.marked).reduce(_ && _)

object Card:
  @targetName("applyRows")
  def apply(rows: Seq[Int]*): Card = Card(
    rows.zipWithIndex.flatMap { (row, rowIndex) =>
      row.zipWithIndex.map { (value, columnIndex) =>
        Number(value, Location(rowIndex, columnIndex))
      }
    }
  )
