name := "comparison-dsl"

organization := "me.jeffshaw.comparison"

version := "1.0"

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.11", "2.10.7")

publishMavenStyle := true

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)
