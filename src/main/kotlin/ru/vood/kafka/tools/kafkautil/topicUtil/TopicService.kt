package ru.vood.kafka.tools.kafkautil.topicUtil

import org.apache.kafka.clients.admin.Admin
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.stereotype.Service

@Service
class TopicService(
    val kafkaAdmin: Admin
) {

    fun create(topicProperty: List<NewTopic>) {
        kafkaAdmin.createTopics(topicProperty)
    }

    fun delete(topicProperty: List<String>) {
        kafkaAdmin.deleteTopics(topicProperty)
    }

}