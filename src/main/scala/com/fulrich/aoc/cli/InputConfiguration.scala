package com.fulrich.aoc.cli

import java.io.File
import org.rogach.scallop._
import com.fulrich.aoc.input._
import com.fulrich.aoc.AocDefaults
import java.nio.file.Files
import java.nio.file.Paths

trait InputConfiguration(aocDefaults: AocDefaults = new AocDefaults) { this: ScallopConf =>
    val problemInput = group("Data Input:")
    val resource = opt[String](
      group = problemInput,
      descr = "Supply puzzle input as one of the resources.",
    )
    val file = opt[File](
      group = problemInput,
      descr = "Supply puzzle input from a file path."
    )

    validateFileExists(file)
    mutuallyExclusive(resource, file)

    def inputRequest(day: Int = (new AocDefaults).day, part: Int = 1): InputRequest = {
      if(resource.isDefined) then return ResourceRequest(resource())
      if(file.isDefined) then return FileRequest(file())

      if resourceExists(s"day_${day}_part_${part}") then ResourceRequest(s"day_${day}_part_${part}")
      else ResourceRequest(s"day_${day}")
    }

    private def resourceExists(name: String): Boolean =
      Option(getClass.getClassLoader.getResource(name)).isDefined
  }