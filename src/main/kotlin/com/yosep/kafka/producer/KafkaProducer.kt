package com.yosep.kafka.producer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Service

const val TOPIC = "exam";
const val REACTIVE_TOPIC = "reactive-exam"

@Service
class KafkaProducer @Autowired constructor(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<String, String>,
) {
    fun sendMessage(message: String) {
        println("Produce message: $message")
        this.kafkaTemplate.send(TOPIC, message)
    }
    
    fun sendMessageReactive(message: String) {
        println("Reactive Produce message: $message")
        this.reactiveKafkaProducerTemplate.send(REACTIVE_TOPIC, message)
            .doOnError {
                println("send fail.")
            }
            .doOnSuccess {
                println("send success.")
            }

    }

}