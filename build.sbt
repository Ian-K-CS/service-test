ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "TechTest"
  )

val http4sVersion = "0.23.18"
val http4sBlaze = "0.23.13"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sBlaze,
  "org.http4s" %% "http4s-blaze-client" % http4sBlaze,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  // Optional for auto-derivation of JSON codecs
  "io.circe" %% "circe-generic" % "0.14.4",
  // Optional for string interpolation to JSON model
  "io.circe" %% "circe-literal" % "0.14.4",
  "com.softwaremill.sttp.client3" %% "core" % "3.8.12",
  "com.softwaremill.sttp.client3" %% "circe" % "3.8.12"
)
