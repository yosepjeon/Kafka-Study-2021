package com.yosep.kafka.consumer

import com.yosep.kafka.producer.REACTIVE_TOPIC
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException
import kotlin.jvm.Throws

@Service
class KafkaConsumer {

    @Throws(IOException::class)
    @KafkaListener(topics = ["exam"], groupId = "foo")
    fun consume(message: String) {
        println("Consumed message $message")
    }

    @Throws(IOException::class)
    @KafkaListener(topics = [REACTIVE_TOPIC], groupId = "foo")
    fun reactiveConsume(message: String) {
        println("Consumed message $message")
    }
}