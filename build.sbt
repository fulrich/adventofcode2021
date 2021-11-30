val scala3Version = "3.1.0"
val scalacticVersion = "3.2.10"

lazy val root = project
  .in(file("."))
  .settings(
    name := "adventofcode2021",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % scalacticVersion,
      "org.scalatest" %% "scalatest" % scalacticVersion % Test
    )
  )
