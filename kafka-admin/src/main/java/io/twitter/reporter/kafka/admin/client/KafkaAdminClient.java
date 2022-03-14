package io.twitter.reporter.kafka.admin.client;

import io.twitter.reporter.config.KafkaConfiguration;
import io.twitter.reporter.config.RetryConfiguration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaAdminClient {

    private final KafkaConfiguration kafkaConfiguration;

    private final RetryConfiguration retryConfiguration;

    private final AdminClient adminClient;

    private final RetryTemplate retryTemplate;

}
