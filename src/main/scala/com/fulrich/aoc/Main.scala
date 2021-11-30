package com.fulrich.aoc

object Main:
  def main(args: Array[String]): Unit = {
    val configuration = new CommandLineConfig(args)
    ResourceLoader.asLines(configuration.resource()).foreach(println)
  }
