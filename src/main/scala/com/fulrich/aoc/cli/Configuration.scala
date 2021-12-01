package com.fulrich.aoc.cli

import org.rogach.scallop._
import com.fulrich.aoc.input._
import java.io.File

class Configuration(arguments: Seq[String]) extends ScallopConf(arguments) {
  val resource = opt[String]()
  val file = opt[File]()
  
  validateFileExists(file)
  verify()

  def inputRequest: InputRequest = {
    if(resource.isDefined) then return ResourceRequest(resource())
    if(file.isDefined) then return FileRequest(file())

    ResourceRequest("default")
  }
}