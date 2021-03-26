package com.yosep.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
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