package ru.vood.kafka.tools.kafkautil.topicUtil

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "kafka.topic.create")
data class CreateTopics(

                        var numPartitions: Int =2,
                        var replicationFactor: Short=2,
                        var names: List<String> = listOf()
)
