package ru.vood.kafka.tools.kafkautil.filler

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

typealias TopicName = String

@Component
@ConfigurationProperties(prefix = "load")
data class SourceByTopic(
    var source: Map<String, SourceFolder> = HashMap(),

    )
