package com.fulrich.aoc.submarine.window.lanternfish

import scala.annotation.{tailrec, targetName}

case class School(reproducingFish: Seq[Long], maturingFish: Seq[Long]):
  lazy val totalFish: Long = reproducingFish.sum + maturingFish.sum

  def observeOver(days: Int): School = School.observe(this, days)

  def nextSpawn: School = copy(
    reproducingFish = reproducingFish.tail :+ (maturingFish.head + reproducingFish.head),
    maturingFish = maturingFish.tail :+ reproducingFish.head,
  )

object School:
  def parse(initialFish: String, reproductionCycle: Int = 7, maturityTime: Int = 2): School =
    apply(initialFish.split(",").map(_.toLong))

  def apply(initialFish: Seq[Long], reproductionCycle: Int = 7, maturityTime: Int = 2): School = {
    val fishCounts = Seq.tabulate(reproductionCycle + maturityTime) { index => initialFish.count(_ == index + 1).toLong }
    val (reproducingFish, maturingFish) = fishCounts.splitAt(reproductionCycle)

    School(reproducingFish, maturingFish)
  }

  @tailrec
  def observe(school: School, day: Int): School = 
    if day == 1 then school else observe(school.nextSpawn, day - 1)
