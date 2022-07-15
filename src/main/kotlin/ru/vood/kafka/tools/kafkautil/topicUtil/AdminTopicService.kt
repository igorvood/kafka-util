package ru.vood.kafka.tools.kafkautil.topicUtil

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import java.util.*

@Service
class AdminTopicService(
    val topicService: TopicService,
    val create: CreateTopics?
) : CommandLineRunner {

    override fun run(vararg args: String?) {
//        val create = topicProperty.create
        println(1)
        Optional.ofNullable(create)
            .map { cr ->
                val newTopics = cr.names.map { NewTopic(it, cr.numPartitions, cr.replicationFactor) }
                topicService.create(newTopics)
            }

//        topicService.delete(topicProperty.delete)
    }
}