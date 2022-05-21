package ru.vood.kafka.tools.kafkautil.filler

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

typealias TopicName = String

@Component
@ConfigurationProperties(prefix = "load")
data class SourceByTopic(var source: Map<String, SourceFolder> = HashMap<String, SourceFolder>(),
                         var str: Map<String, String> = HashMap<String, String>()
)
