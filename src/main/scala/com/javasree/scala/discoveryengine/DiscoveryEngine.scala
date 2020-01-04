package com.javasree.scala.discoveryengine

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class DiscoveryEngine extends SpringBootServletInitializer

object DiscoveryEngine extends App{
  SpringApplication.run(classOf[DiscoveryEngine])
}