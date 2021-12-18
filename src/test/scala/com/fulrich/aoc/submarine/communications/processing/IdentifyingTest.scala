package com.fulrich.aoc.submarine.communications.processing

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class IdentificationProcessingTest extends AnyFunSuite:
  test("Can process version and type ID for a Literal") {
    // 1101 0010
    // VVVT TT

    val initial = Identifying.start('1').next('1')
    initial shouldBe a[IdentifyingVersion]
    initial.isComplete shouldBe false

    val withVersion = initial.next('0')
    withVersion shouldBe a[IdentifyingType]
    withVersion.asInstanceOf[IdentifyingType].version shouldBe 6

    val almostIdentified = withVersion.next('1').next('0')
    almostIdentified shouldBe a[IdentifyingType]
    almostIdentified.asInstanceOf[IdentifyingType].version shouldBe 6

    val identified = almostIdentified.next('0')
    identified shouldBe a[ProcessLiteral]

    val processLiteral = identified.asInstanceOf[ProcessLiteral]
    processLiteral.header.version shouldBe 6
    processLiteral.header.typeId shouldBe 4
  }
