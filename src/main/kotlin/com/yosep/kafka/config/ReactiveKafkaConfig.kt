package com.yosep.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.IntegerSerializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import reactor.kafka.sender.SenderOptions

import reactor.kafka.receiver.ReceiverOptions
import java.util.*


@Configuration
class ReactiveKafkaConfig {
    private val BOOTSTRAP_SERVERS = "localhost:9092"
    private val TOPIC = "reactive-topic"

    private var consumerProps: MutableMap<String, Any>? = null
    private var producerProps: MutableMap<String, Any>? = null

    @Bean
    fun getReactiveKafkaProducerTemplate(): ReactiveKafkaProducerTemplate<String, String> {
        producerProps = mutableMapOf()
        producerProps!![ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        producerProps!![ProducerConfig.CLIENT_ID_CONFIG] = "producer"
        producerProps!![ProducerConfig.ACKS_CONFIG] = "all"
        producerProps!![ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        producerProps!![ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java

        val options: SenderOptions<String, String> = SenderOptions.create(producerProps!!)

        return ReactiveKafkaProducerTemplate<String, String>(options)
    }

    @Bean
    fun getReactiveKafkaConsumerTemplate(): ReactiveKafkaConsumerTemplate<String, String> {
        consumerProps = mutableMapOf()
        consumerProps!![ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        consumerProps!![ConsumerConfig.CLIENT_ID_CONFIG] = "consumer"
        consumerProps!![ConsumerConfig.GROUP_ID_CONFIG] = "group"
        consumerProps!![ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        consumerProps!![ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        consumerProps!![ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"

        val options: ReceiverOptions<String, String> = ReceiverOptions.create<String, String>(
            consumerProps!!
        )
            .subscription(Collections.singleton(TOPIC))

        return ReactiveKafkaConsumerTemplate(options)
    }
}