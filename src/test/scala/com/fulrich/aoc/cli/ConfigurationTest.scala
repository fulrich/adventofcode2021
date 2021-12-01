package com.fulrich.aoc.cli

import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite
import com.fulrich.aoc.input._
import com.fulrich.aoc.FileTesting

class MainTest extends AnyFunSuite with FileTesting:
  test("Passing a resource flag will create a ResourceInput") {
    configuration("--resource", "test").inputRequest shouldBe ResourceRequest("test")
  }

  test("Passing a file flag will create a FileInput") {
    withFile { file =>
      configuration("--file", file.getPath).inputRequest shouldBe FileRequest(file)
    }
  }

  def configuration(arguments: String*): Configuration = 
    new Configuration(arguments.toArray)