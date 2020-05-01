import sbt._

object Dependencies {

  val springBootVersion = "2.1.3.RELEASE"
  val springCloudVersion = "Greenwich.RELEASE"

  val springDependencies: Seq[ModuleID] = Seq(
    "org.springframework.boot" % "spring-boot-starter-parent" % springBootVersion,
    "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
    "org.springframework.boot" % "spring-boot-starter-test" % springBootVersion,
    "org.springframework.cloud" % "spring-cloud-starter-netflix-eureka-client" % springBootVersion,
    "org.springframework.cloud" % "spring-cloud-starter-netflix-eureka-server" % springBootVersion
  )
  
}
