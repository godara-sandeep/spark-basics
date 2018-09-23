name := "spark-basic-stream"

version := "0.1"

scalaVersion := "2.11.12"
exportJars := true

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.1"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.3.1" % "provided"
