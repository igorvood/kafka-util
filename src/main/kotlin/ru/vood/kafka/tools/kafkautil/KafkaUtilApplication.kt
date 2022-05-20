package ru.vood.kafka.tools.kafkautil

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaUtilApplication

fun main(args: Array<String>) {
    runApplication<KafkaUtilApplication>(*args)
}
