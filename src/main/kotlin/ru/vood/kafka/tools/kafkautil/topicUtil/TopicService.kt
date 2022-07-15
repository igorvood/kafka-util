package ru.vood.kafka.tools.kafkautil.topicUtil

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.kafka.core.KafkaAdmin
import org.springframework.stereotype.Service

@Service
class TopicService(
    val kafkaAdmin: KafkaAdmin
) {

    fun create(topicProperty: List<NewTopic>) {
        kafkaAdmin.createOrModifyTopics(*topicProperty.toTypedArray())
    }

    fun delete(topicProperty: List<String>) {
        kafkaAdmin.describeTopics()
        kafkaAdmin.describeTopics(*topicProperty.toTypedArray())
    }

}