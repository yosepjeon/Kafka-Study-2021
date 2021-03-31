package com.yosep.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class YosepSpringApplication {
}

fun main(args: Array<String>) {
    runApplication<YosepSpringApplication>(*args)
}

//@SpringBootApplication
//class YosCouponApiApplication
//
//fun main(args: Array<String>) {
//    runApplication<YosCouponApiApplication>(*args)
//}