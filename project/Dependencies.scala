import sbt._

object Dependencies {
  lazy val commonDep = Seq(
    "org.scalatest" %% "scalatest" % "3.0.4" % Test,
    "org.scalamock" %% "scalamock" % "4.0.0" % Test
  )
}
