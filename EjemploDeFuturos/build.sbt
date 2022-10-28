ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "EjemploDeFuturos",
      libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.4.0",
      libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.7.0",
      libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.7.0"
  )
