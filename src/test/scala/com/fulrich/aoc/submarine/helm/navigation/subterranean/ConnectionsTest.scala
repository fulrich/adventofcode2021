package com.fulrich.aoc.submarine.helm.navigation.subterranean

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class ConnectionsTest extends AnyFunSuite:
  val simpleConnections = Seq(
    "start-A",
    "start-b",
    "A-c",
    "A-b",
    "b-d",
    "A-end",
    "b-end"
  )

  test("Can determine the connections available from a Cave") {
    val connections = Connections.parse(simpleConnections)

    connections.from(Start) should contain theSameElementsAs Seq(Cave("A"), Cave("b"))
    connections.from(Cave("A")) should contain theSameElementsAs Seq(Cave("c"), Cave("b"), Start, End)
    connections.from(Cave("b")) should contain theSameElementsAs Seq(Cave("A"), Cave("d"), Start, End)
    connections.from(Cave("d")) should contain theSameElementsAs Seq(Cave("b"))
    connections.from(Cave("c")) should contain theSameElementsAs Seq(Cave("A"))
    connections.from(End) should contain theSameElementsAs Seq(Cave("A"), Cave("b"))
  }