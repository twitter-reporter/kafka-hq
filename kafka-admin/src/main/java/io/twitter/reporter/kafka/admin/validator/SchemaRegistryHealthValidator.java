package io.twitter.reporter.kafka.admin.validator;

import io.twitter.reporter.config.KafkaAdminProperties;
import io.twitter.reporter.kafka.admin.exception.KafkaClientException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class SchemaRegistryHealthValidator implements KafkaValidator {

    private final KafkaAdminProperties adminProperties;

    private final RetryTemplate retryTemplate;

    private final WebClient webClient;

    public void validate() {
        retryTemplate.execute(this::checkSchemaRegistryHealth);
    }

    private boolean checkSchemaRegistryHealth(final RetryContext retryContext) {
        final String schemaRegistryUrl = adminProperties.getSchemaRegistryUrl();

        return webClient.method(HttpMethod.GET)
                .uri(schemaRegistryUrl)
                .exchangeToMono(clientResponse -> Mono.justOrEmpty(clientResponse.statusCode()))
                .blockOptional()
                .map(HttpStatus::is2xxSuccessful)
                .orElseThrow(() -> new KafkaClientException(String.format("Couldn't get a successful response from schema registry with url: [%s]", schemaRegistryUrl)));
    }

}
