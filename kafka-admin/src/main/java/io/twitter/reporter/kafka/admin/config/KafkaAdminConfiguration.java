package io.twitter.reporter.kafka.admin.config;

import io.twitter.reporter.config.KafkaAdminProperties;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

import java.util.Map;

import static org.apache.kafka.clients.CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG;

@EnableRetry
@Configuration
@AllArgsConstructor
public class KafkaAdminConfiguration {

    private final KafkaAdminProperties kafkaAdminProperties;

    @Bean
    public AdminClient adminClient() {
        final Map<String, Object> configs = Map.of(BOOTSTRAP_SERVERS_CONFIG, kafkaAdminProperties.getBootstrapServers());

        return AdminClient.create(configs);
    }

}
