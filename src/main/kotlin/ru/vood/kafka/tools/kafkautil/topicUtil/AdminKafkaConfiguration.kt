package ru.vood.kafka.tools.kafkautil.topicUtil

import org.apache.kafka.clients.admin.Admin
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AdminKafkaConfiguration {


//    @Bean
    fun kafkaAdmin(kafkaProperties: KafkaProperties): Admin {

        return Admin.create(kafkaProperties.buildAdminProperties())
    }

//    @Bean
    fun topic1(): List<NewTopic> {
        val mutableListOf = mutableListOf(
            NewTopic("baeldung1", 1, 1.toShort()),
            NewTopic("baeldung2", 1, 1.toShort())
        )
//        return NewTopic("baeldung", 1, 1.toShort())
        return mutableListOf
    }

//    @Bean
    fun topic2(): NewTopic {
        return NewTopic("1baeldung", 1, 1.toShort())
    }

}