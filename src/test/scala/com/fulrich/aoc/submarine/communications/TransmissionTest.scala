package com.fulrich.aoc.submarine.communications

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.submarine.communications.packets._
import com.fulrich.aoc.input.DataInput

class TransmissionTest extends AnyFunSuite with LoneElement:
  test("Can processing literal values") {
    //1101 0010 1111 1110 0010 1000
    //VVVT TTAA AAAB BBBB CCCC C
    val result = Transmission("D2FE28")
    
    result.packets.loneElement shouldBe Literal(Header(version = 6,  typeId = 4), 2021)
  }

  test("Test an operator wiith 2 literals") {
    //0011 1000 0000 0000 0110 1111 0100 0101 0010 1001 0001 0010 0000 0000
    //VVVT TTIL LLLL LLLL LLLL LLAA AAAA AAAA ABBB BBBB BBBB BBBB B
    val result = Transmission("38006F45291200")

    result.packets shouldBe Seq(
      Operator(Header(version = 1, typeId = 6), packets = Seq(
        Literal(Header(6, 4), 10),
        Literal(Header(2, 4), 20)
      ))
    )
  }

  test("Test an operator with 3 literals") {
    //11101110000000001101010000001100100000100011000001100000
    //VVVTTTILLLLLLLLLLLAAAAAAAAAAABBBBBBBBBBBCCCCCCCCCCC
    val result = Transmission("EE00D40C823060")

    result.packets shouldBe Seq(
      Operator(Header(version = 7, typeId = 3), packets = Seq(
        Literal(Header(2, 4), 1),
        Literal(Header(4, 4), 2),
        Literal(Header(1, 4), 3)
      ))
    )
  }
  
  test("Can determine the version total for different transmissions") {
    Transmission("8A004A801A8002F478").versionTotal shouldBe 16
    Transmission("620080001611562C8802118E34").versionTotal shouldBe 12
    Transmission("C0015000016115A2E0802F182340").versionTotal shouldBe 23
    Transmission("A0016C880162017C3686B18A3D4780").versionTotal shouldBe 31
  }

  test("Operation tests") {
    Transmission("C200B40A82").value shouldBe 3
    Transmission("04005AC33890").value shouldBe 54
    Transmission("880086C3E88112").value shouldBe 7
    Transmission("CE00C43D881120").value shouldBe 9
    Transmission("D8005AC2A8F0").value shouldBe 1
    Transmission("F600BC2D8F").value shouldBe 0
    Transmission("9C005AC2F8F0").value shouldBe 0
    Transmission("9C0141080250320F1802104A08").value shouldBe 1
  }

  test("Testing real data") {
    val input = DataInput.fromResource("day_16").raw.head
    val result = Transmission(input)

    result.versionTotal shouldBe 996
  }
