package ru.vood.kafka.tools.kafkautil.configuration

import org.springframework.context.annotation.Configuration
import org.apache.kafka.clients.admin.NewTopic

import org.springframework.kafka.core.KafkaAdmin

import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean


@Configuration
class KafkaTopicConfig {

    @Value(value = "\${kafka.bootstrapAddress}")
    private var bootstrapAddress: String = "null"

//    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        return KafkaAdmin(configs)
    }

//    @Bean
    fun topic1(): NewTopic {
        return NewTopic("baeldung", 1, 1.toShort())
    }
}