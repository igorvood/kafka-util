package ru.vood.kafka.tools.kafkautil.filler

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kafka.tools.kafkautil.producer.MessageProducerInterface

@Service
class TopicFiller(
    val messageProducer: MessageProducerInterface<String, String>
    ) : CommandLineRunner {

    override fun run(vararg args: String?) {
        messageProducer.sendMessage("TestTopic", "dasdsad", "asdasdasd")

    }
}