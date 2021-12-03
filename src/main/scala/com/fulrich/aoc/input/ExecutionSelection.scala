package com.fulrich.aoc.input

import java.time.temporal.ChronoUnit;
import java.time.{ Clock, LocalDate };

sealed trait ExecutionSelection

case class AocPuzzle(day: Int, part: Int, data: DataInput) extends ExecutionSelection
case class SubmarineCommand(command: String, data: DataInput) extends ExecutionSelection
case object Unknown extends ExecutionSelection
