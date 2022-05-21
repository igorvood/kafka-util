package ru.vood.kafka.tools.kafkautil

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class KafkaUtilApplication

fun main(args: Array<String>) {
    runApplication<KafkaUtilApplication>(*args)
}
