package com.fulrich.aoc.submarine.helm.navigation.syntax

import ChunkPart._
import org.scalactic._

case class ChunkPair(open: ChunkPart, close: ChunkPart)

object ChunkPair:
  val All: Seq[ChunkPair] = Seq(
    ChunkPair(RoundOpen, RoundClose),
    ChunkPair(SquareOpen, SquareClose),
    ChunkPair(CurlyOpen, CurlyClose),
    ChunkPair(AngleOpen, AngleClose)
  )

  def byOpen(open: ChunkPart): Option[ChunkPair] = All.find(_.open == open)
  def byClose(close: ChunkPart): Option[ChunkPair] = All.find(_.close == close)

  def validate(open: ChunkPart, close: ChunkPart): ChunkPair Or One[ChunkPart] = byOpen(open) match {
    case Some(pair) => if pair.close == close then Good(pair) else Bad(One(close))
    case None => Bad(One(open))
  }
