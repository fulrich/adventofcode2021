package com.fulrich.aoc.submarine.helm.navigation.syntax

class Syntax(lines: Seq[Line]):
  lazy val isValid: Boolean = validationScore == 0
  lazy val isInvalid: Boolean = !isValid
  
  lazy val validationScores: Seq[Long] = invalidParts.map(_.invalidPoints).sorted
  lazy val validationScore: Long = validationScores.sum

  lazy val autoCompleteScores: Seq[Long] = validIncompleteLines.map(_.autoCompleteScore).sorted
  lazy val autoCompleteScore: Long = autoCompleteScores(validIncompleteLines.length / 2)

  lazy val invalidParts: Seq[ChunkPart] = lines.flatMap(_.invalid)
  lazy val validIncompleteLines: Seq[Line] = lines.filter(line => line.isIncomplete && line.isValid)

object Syntax:
  def validate(input: Seq[String]): Syntax = new Syntax(input.map(Line.validate))
