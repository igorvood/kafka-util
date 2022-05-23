package ru.vood.kafka.tools.kafkautil.topicUtil

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class AdminTopicService(
    val topicService: TopicService,
    val topicProperty: TopicProperty
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        topicService.create(topicProperty.create)
        topicService.delete(topicProperty.delete)
    }
}