package com.fulrich.aoc.submarine.helm

sealed trait HelmCommand
case class Forward(value: Int) extends HelmCommand
case class Down(value: Int) extends HelmCommand
case class Up(value: Int) extends HelmCommand

object HelmCommand:
  def parseList(inputs: Seq[String]): Seq[HelmCommand] = inputs.map(parse)

  def parse(input: String): HelmCommand = input.split(" ").toSeq match {
    case Seq("forward", a) => Forward(a.toInt)
    case Seq("down", a) => Down(a.toInt)
    case Seq("up", a) => Up(a.toInt)
  }
