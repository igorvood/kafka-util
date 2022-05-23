package ru.vood.kafka.tools.kafkautil.topicUtil

import org.apache.kafka.clients.admin.Admin
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdminKafkaConfiguration {


//    @Bean
    fun kafkaAdmin(kafkaProperties: KafkaProperties): Admin {
        return Admin.create(kafkaProperties.buildAdminProperties())
    }
}