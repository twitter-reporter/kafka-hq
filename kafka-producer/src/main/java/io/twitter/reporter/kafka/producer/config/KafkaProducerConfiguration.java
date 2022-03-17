package io.twitter.reporter.kafka.producer.config;

import io.twitter.reporter.config.KafkaAdminProperties;
import io.twitter.reporter.config.KafkaProducerProperties;
import lombok.RequiredArgsConstructor;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.io.Serializable;
import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
@RequiredArgsConstructor
public class KafkaProducerConfiguration<K extends Serializable, V extends SpecificRecordBase> {

    private final KafkaAdminProperties adminProperties;

    private final KafkaProducerProperties producerProperties;

    @Bean
    public Map<String, Object> producerConfig() {
        return Map.of(BOOTSTRAP_SERVERS_CONFIG, adminProperties.getBootstrapServers(),
                adminProperties.getSchemaRegistryUrlKey(), adminProperties.getSchemaRegistryUrl(),
                KEY_SERIALIZER_CLASS_CONFIG, producerProperties.getKeySerializerClass(),
                VALUE_SERIALIZER_CLASS_CONFIG, producerProperties.getValueSerializerClass(),
                COMPRESSION_TYPE_CONFIG, producerProperties.getCompressionType(),
                ACKS_CONFIG, producerProperties.getAcks(),
                BATCH_SIZE_CONFIG, producerProperties.getBatchSize() * producerProperties.getBatchSizeBoostFactor(),
                LINGER_MS_CONFIG, producerProperties.getLingerMs(),
                REQUEST_TIMEOUT_MS_CONFIG, producerProperties.getRequestTimeoutMs(),
                RETRIES_CONFIG, producerProperties.getRetryCount());
    }

    @Bean
    public ProducerFactory<K, V> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }


    @Bean
    public KafkaTemplate kafkaTemplate() {
        return new KafkaTemplate(producerFactory());
    }

}
