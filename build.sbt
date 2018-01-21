name := """play-java-spring-hibernate"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  javaCore,
  cache,
  javaWs,
  jdbc,
  "org.hibernate" % "hibernate-entitymanager" % "5.0.1.Final",
  "org.hibernate" % "hibernate-envers" % "5.0.1.Final",
  "org.springframework" % "spring-context" % "4.2.7.RELEASE",
  "org.springframework" % "spring-tx" % "4.2.7.RELEASE",
  "org.springframework" % "spring-jdbc" % "4.2.7.RELEASE",
  "org.springframework" % "spring-orm" % "4.2.7.RELEASE",
  "org.springframework" % "spring-expression" % "4.2.7.RELEASE",
  "mysql" % "mysql-connector-java" % "5.1.36",
  "org.apache.commons" % "commons-lang3" % "3.4"
)
