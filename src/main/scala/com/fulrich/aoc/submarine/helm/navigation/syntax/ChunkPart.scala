package com.fulrich.aoc.submarine.helm.navigation.syntax

enum ChunkPart(val character: Char, val isOpen: Boolean, val invalidPoints: Long = 0, val autoCompletePoints: Long = 0):
  val isClose: Boolean = !isOpen

  case RoundOpen extends ChunkPart('(', isOpen = true)
  case RoundClose extends ChunkPart(')', isOpen = false, invalidPoints = 3, autoCompletePoints = 1)
  case SquareOpen extends ChunkPart('[', isOpen = true)
  case SquareClose extends ChunkPart(']', isOpen = false, invalidPoints = 57, autoCompletePoints = 2)
  case CurlyOpen extends ChunkPart('{', isOpen = true)
  case CurlyClose extends ChunkPart('}', isOpen = false, invalidPoints = 1197, autoCompletePoints = 3)
  case AngleOpen extends ChunkPart('<', isOpen = true)
  case AngleClose extends ChunkPart('>', isOpen = false, invalidPoints = 25137, autoCompletePoints = 4)

object ChunkPart:
  def apply(character: Char): ChunkPart = values.find(_.character == character).get

  def from(input: String): Seq[ChunkPart] = input.toSeq.map(apply)
