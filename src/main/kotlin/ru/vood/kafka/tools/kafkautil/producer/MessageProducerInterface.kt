package ru.vood.kafka.tools.kafkautil.producer

interface MessageProducerInterface<K, V> {

    fun sendMessage(topicName: String, key: K?, message: V)

}
