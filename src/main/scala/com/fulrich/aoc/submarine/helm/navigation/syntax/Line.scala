package com.fulrich.aoc.submarine.helm.navigation.syntax

import org.scalactic._
import scala.annotation.tailrec

case class Line(processed: Seq[ChunkPart], invalid: Option[ChunkPart] = None, incomplete: Seq[ChunkPart] = Seq.empty):
  val isValid: Boolean = invalid.isEmpty
  val isInvalid: Boolean = !isValid

  val isComplete: Boolean = incomplete.isEmpty
  val isIncomplete: Boolean = !isComplete

  lazy val completedBy: Seq[ChunkPart] = incomplete.flatMap(ChunkPair.byOpen).map(_.close).reverse
  lazy val autoCompleteScore: Long = completedBy.foldLeft(0L) { case(total, part) => (total * 5L) + part.autoCompletePoints }

  def validateNext(part: ChunkPart): Line  = if part.isOpen then validateOpeningPart(part) else validateClosingPart(part)

  private def validateOpeningPart(open: ChunkPart): Line = copy(processed = processed :+ open, incomplete = incomplete :+ open)

  private def validateClosingPart(close: ChunkPart): Line = ChunkPair.validate(incomplete.last, close) match {
    case Good(pair) => copy(processed = processed :+ close, incomplete = incomplete.init)
    case Bad(One(invalid)) => if isInvalid then this else copy(invalid = Some(close))
  }

object Line:
  val empty: Line = Line(Seq.empty)

  def validate(remaining: String): Line = validate(ChunkPart.from(remaining), Line.empty)

  @tailrec
  def validate(unprocessed: Seq[ChunkPart], line: Line): Line =
    if unprocessed.isEmpty then line else  validate(unprocessed.tail, line.validateNext(unprocessed.head))
