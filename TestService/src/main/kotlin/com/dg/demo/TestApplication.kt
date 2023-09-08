package com.dg.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class TestApplication

fun main(args: Array<String>) {
	runApplication<TestApplication>(*args)
}
