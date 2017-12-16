import sbt._

object Dependencies {
  lazy val commonDep = Seq(
    "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  )
}
