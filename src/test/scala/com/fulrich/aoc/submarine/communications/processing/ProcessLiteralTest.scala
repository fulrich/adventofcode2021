package com.fulrich.aoc.submarine.communications.processing

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.submarine.communications._

class ProcessLiteralTest extends AnyFunSuite with OptionValues:
  test("Can process a full literal") {
    // 10
    // AA
    val initial = ProcessLiteral(6, 4, Raw.empty).next('1').next('0')
    initial.isComplete shouldBe false
    initial.indicatorIndex shouldBe 0

    // 10 1111
    // AA AAAB
    val firstChunk = initial.next('1').next('1').next('1').next('1')
    firstChunk.isComplete shouldBe false
    firstChunk.indicatorIndex shouldBe 5

    // 10 1111 1110
    // AA AAAB BBBB
    val secondChunk = firstChunk.next('1').next('1').next('1').next('0')
    secondChunk.isComplete shouldBe false
    secondChunk.indicatorIndex shouldBe 5

    // 10 1111 1110 0010
    // AA AAAB BBBB CCCC
    val thirdChunk = secondChunk.next('0').next('0').next('1').next('0')
    thirdChunk.isComplete shouldBe false
    thirdChunk.indicatorIndex shouldBe 10

    // 10 1111 1110 0010 1
    // AA AAAB BBBB CCCC C
    val finalChunk = thirdChunk.next('1')
    finalChunk.isComplete shouldBe true
    finalChunk.indicatorIndex shouldBe 10
    finalChunk.asDigit shouldBe 2021

    val packet = finalChunk.packet.value
    packet.header.version shouldBe 6
    packet.header.typeId shouldBe 4
    packet.value shouldBe 2021
  }
