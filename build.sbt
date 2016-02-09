organization := "interretis"
name := "spark-testing"
version := "1.1"

scalaVersion := "2.11.7"
scalacOptions ++= Seq("-deprecation", "-explaintypes", "-feature", "-unchecked", "-optimise", "-target:jvm-1.8")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.0" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-sql"  % "1.6.0" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-hive" % "1.6.0" withSources() withJavadoc(),
  "org.scalatest" %% "scalatest" % "2.2.4" withSources() withJavadoc()
)

scalastyleConfig := file("project/scalastyle_config.xml")

parallelExecution in Test := false
