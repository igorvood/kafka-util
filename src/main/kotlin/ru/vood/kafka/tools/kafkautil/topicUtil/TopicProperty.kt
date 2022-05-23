package ru.vood.kafka.tools.kafkautil.topicUtil

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "topic")
data class TopicProperty(
    var create: List<NewTopic> = listOf(),
    var delete: List<String> = listOf()
) {
    init {
        val filter = create.map { it.name() }.filter { delete.contains(it) }
        assert(filter.isEmpty()) { "создавайемы и удаляемые очереди не должны совпадать, пересечение множеств $filter" }
    }
}