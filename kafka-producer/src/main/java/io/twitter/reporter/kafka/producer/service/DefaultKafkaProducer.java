package io.twitter.reporter.kafka.producer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PreDestroy;
import java.io.Serializable;

@Slf4j
@Service
@AllArgsConstructor
public class DefaultKafkaProducer<K extends Serializable, V extends SpecificRecordBase> implements KafkaProducer<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;

    @Override
    public void send(final String topicName, final K key, final V message) {
        log.info("Sending message: [{}], with key: [{}] to topic: [{}]", message, key, topicName);
        final ListenableFuture<SendResult<K, V>> future = kafkaTemplate.send(topicName, key, message);
        future.addCallback(getCallback(topicName, message));
    }

    @PreDestroy
    public void close() {
        if (kafkaTemplate != null) {
            log.info("Destroying kafka producer...");
            kafkaTemplate.destroy();
        }
    }

    private ListenableFutureCallback<SendResult<K, V>> getCallback(final String topicName, final V message) {
        return new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Couldn't send the message: [{}] to topic: [{}]", message, topicName, ex);
            }

            @Override
            public void onSuccess(SendResult<K, V> result) {
                final RecordMetadata metadata = result.getRecordMetadata();
                log.info("Message: [{}] was sent to topic: [{}] in partition: [{}] and offset: [{}] at: [{}]",
                        message, topicName, metadata.partition(), metadata.offset(), System.nanoTime());
            }
        };
    }
}
