name := "comparison-dsl"

organization := "me.jeffshaw.comparison"

version := "1.0.1"

scalaVersion := "3.0.1"

crossScalaVersions := Seq("2.13.6", "2.12.14", "2.11.12", "2.10.7")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

Compile / scalaSource := {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, _)) =>
      baseDirectory.value / "src" / "main" / "scala-2"
    case Some((3, _)) =>
      baseDirectory.value / "src" / "main" / "scala-3"
  }
}

licenses := Seq("The BSD 3-Clause License" -> url("http://opensource.org/licenses/BSD-3-Clause"))

homepage := Some(url("https://github.com/shawjef3/comparison-dsl"))

pomExtra :=
  <developers>
    <developer>
      <name>Jeff Shaw</name>
      <id>shawjef3</id>
      <url>https://github.com/shawjef3/</url>
    </developer>
  </developers>
  <scm>
    <url>git@github.com:shawjef3/comparison-dsl.git</url>
    <connection>scm:git:git@github.com:rocketfuel/sdbc.git</connection>
  </scm>
