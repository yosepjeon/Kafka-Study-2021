package com.yosep.kafka.producer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kafka.sender.SenderResult
import java.util.*

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
    
    fun sendMessageReactive(message: String): Mono<SenderResult<Void>> {
        println("Reactive Produce message: $message")
        return this.reactiveKafkaProducerTemplate.send(REACTIVE_TOPIC, message)
            .doOnError {
                println("send fail.")
            }
            .doOnSuccess {
                println("send success.")
            }

    }

}