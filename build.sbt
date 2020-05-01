import BuildUtils.readVersion

name := "DiscoveryEngine"
version := "0.1"
scalaVersion := "2.13.1"
organization := "com.javasree.scala.discoveryengine"
publishMavenStyle := true

lazy val artifactoryRepo = settingKey[sbt.librarymanagement.Resolver]("Artifactory repository value")

isSnapshot := {
  sys.props.getOrElse("DISCOVERY_ENGINE_SNAPSHOT", sys.env.getOrElse("DISCOVERY_ENGINE_SNAPSHOT", "true")) match {
    case "true" | "1" => true
    case "false" | "0" => false
    case _ => println("taking the default value as true for 'SNAPSHOT'")
      true
  }
}

publishArtifact in (Compile, packageDoc) := false
publishArtifact in (Compile, packageSrc) := false

/*
if env variable(DISCOVERY_ENGINE_SNAPSHOT) is set to true then build will do "snapshot"
or else it will be "release"
* */
version := {
  readVersion("app-build")+
    (isSnapshot.value match {
      case true => "-SNAPSHOT"
      case false => ""
    })
}

artifactoryRepo := {
  val repoURL = "http://localhost:8081/artifactory"
  (isSnapshot.value match {
    case true => "jfrog-snapshot" at s"${repoURL}/javasree-sbt-snapshot;build.timestamp=" + new java.util.Date().getTime
    case false => "jfrog-remote" at s"${repoURL}/javasree-sbt-local"
  })
}

publishTo := Some( artifactoryRepo.value )
credentials += Credentials("Artifactory Realm", "localhost", "admin", "password")


  libraryDependencies ++= Seq(
    "com.google.code.gson" % "gson" % "2.8.2"
  )++Dependencies.springDependencies