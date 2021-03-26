package com.yosep.kafka.controller

import com.yosep.kafka.producer.KafkaProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaController @Autowired constructor(
    private val producer:KafkaProducer
) {
    @PostMapping
    fun sendMessage(@RequestParam("message") message: String): String {
        producer.sendMessage(message)

        return "success"
    }
}