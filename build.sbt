name := """play-raspi"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "com.pi4j" % "pi4j-core" % "1.0-SNAPSHOT"
)

resolvers ++= Seq(
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
  "Sonatype OSS Maven Repository" at "https://oss.sonatype.org/content/groups/public"
)