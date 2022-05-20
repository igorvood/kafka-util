package ru.vood.kafka.tools.kafkautil.configuration

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import java.util.*

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress: String? = null

    fun consumerFactory(groupId: String?): ConsumerFactory<String?, String?> {
        val props: MutableMap<String, Any?> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = groupId
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG] = "20971520"
        props[ConsumerConfig.FETCH_MAX_BYTES_CONFIG] = "20971520"
        return DefaultKafkaConsumerFactory(props)
    }

    fun kafkaListenerContainerFactory(groupId: String): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.setConsumerFactory(consumerFactory(groupId))
        return factory
    }

    @Bean
    fun fooKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        return kafkaListenerContainerFactory("foo")
    }

    @Bean
    fun barKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        return kafkaListenerContainerFactory("bar")
    }

    @Bean
    fun headersKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        return kafkaListenerContainerFactory("headers")
    }

    @Bean
    fun partitionsKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        return kafkaListenerContainerFactory("partitions")
    }

    @Bean
    fun longMessageKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        return kafkaListenerContainerFactory("longMessage")
    }

    @Bean
    fun filterKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = kafkaListenerContainerFactory("filter")
        factory.setRecordFilterStrategy { record: ConsumerRecord<String, String> ->
            record.value()
                .contains("World")
        }
        return factory
    }

    /* fun greetingConsumerFactory(): ConsumerFactory<String, Greeting> {
         val props: MutableMap<String, Any> = HashMap()
         props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
         props[ConsumerConfig.GROUP_ID_CONFIG] = "greeting"
         return DefaultKafkaConsumerFactory<Any, Any>(
             props, StringDeserializer(), JsonDeserializer<Any>(
                 Greeting::class.java
             )
         )
     }*/

    /* @Bean
     fun greetingKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Greeting>? {
         val factory: ConcurrentKafkaListenerContainerFactory<String, Greeting> =
             ConcurrentKafkaListenerContainerFactory<String, Greeting>()
         factory.setConsumerFactory(greetingConsumerFactory())
         return factory
     }*/


}