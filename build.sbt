name := "comparison-dsl"

organization := "me.jeffshaw.comparison"

version := "1.0.1"

scalaVersion := "2.13.6"

crossScalaVersions := Seq("2.12.4", "2.11.14", "2.10.7")

publishMavenStyle := true

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.3" % Test
)
