package com.yosep.kafka.controller.router

import com.yosep.kafka.controller.handler.KafkaTestHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.router

@Configuration
class KafkaTestRouter @Autowired constructor(
    private val kafkaTestHandler: KafkaTestHandler
) {
    @Bean
    fun routerFunction() = RouterFunctions.nest(
        RequestPredicates.path("/reactive/kafka"),
        router {
            listOf(
                GET("/test0", kafkaTestHandler::test),
                POST("/test1",kafkaTestHandler::sendMessageTest1)
            )
        })
}