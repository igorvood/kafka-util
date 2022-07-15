package ru.vood.kafka.tools.kafkautil.topicUtil

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.util.*

@Component
@ConfigurationProperties(prefix = "topic")
data class TopicProperty(
    var create: CreateTopics? = null,
    var delete: List<String> = listOf()
) {

    init {
        Optional.ofNullable(create)
            .map { cr -> cr.names.filter { delete.contains(it) } }
            .map { assert(it.isEmpty()) { "создавайемы и удаляемые очереди не должны совпадать, пересечение множеств $it" } }

    }

    data class CreateTopics(

        var numPartitions: Int,
        var replicationFactor: Short,
        var names: List<String>
    )

}