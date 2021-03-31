package com.yosep.kafka.controller.handler

import com.yosep.kafka.producer.KafkaProducer
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class KafkaTestHandler constructor(
    private val kafkaProducer: KafkaProducer
) {
    fun test(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().build()
    }

    fun sendMessageTest1(req: ServerRequest): Mono<ServerResponse> {

        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(kafkaProducer.sendMessageReactive(req.queryParam("message").get())
                .doOnSuccess { println("success") }
                .doOnError { println("error") }
            )
    }

}