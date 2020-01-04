name := "DiscoveryEngine"
version := "0.1"
scalaVersion := "2.13.1"
organization := "com.javasree.scala.discoveryengine"

val springBootVersion = "2.1.3.RELEASE"
val springCloudVersion = "Greenwich.RELEASE"

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-parent" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-test" % springBootVersion,
  "org.springframework.cloud" % "spring-cloud-starter-netflix-eureka-client" % springBootVersion,
  "org.springframework.cloud" % "spring-cloud-starter-netflix-eureka-server" % springBootVersion,
  "com.google.code.gson" % "gson" % "2.8.2"
)