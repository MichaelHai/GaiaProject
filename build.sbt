import Dependencies._
import Common._


lazy val commonSettings = Defaults.coreDefaultSettings ++ Seq(
  version := "1.0",
  scalaVersion := "2.12.1",
  libraryDependencies ++= commonDep
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(name := namePrefix)
  .aggregate(core)

lazy val core = project
  .settings(commonSettings)
  .settings(name := namePrefix + " Core")