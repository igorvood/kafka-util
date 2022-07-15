package ru.vood.kafka.tools.kafkautil.filler

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kafka.tools.kafkautil.producer.MessageProducerInterface
import java.io.File

@Service
class TopicFiller(
    val messageProducer: MessageProducerInterface<String, String>,
    val sourse: SourceByTopic
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val data = sourse.source.flatMap { s ->
            val dir = File(s.value.folderName)
            val list = if (dir.isDirectory) {
                dir.listFiles()
                    .filter { f -> f.isFile }
                    .map { q ->
                        q.name to q.readText()
                    }
            } else throw IllegalStateException("""Не директория $dir""")
            list.map { data -> TopicInfo(s.key, data.first, data.second) }
        }.toSet()


        data.forEach { d -> messageProducer.sendMessage(d.topic, null, d.message) }


    }
}