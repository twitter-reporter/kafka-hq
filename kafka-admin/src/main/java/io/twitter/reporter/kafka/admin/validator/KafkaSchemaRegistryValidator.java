package io.twitter.reporter.kafka.admin.validator;

import io.twitter.reporter.config.KafkaConfiguration;
import io.twitter.reporter.kafka.admin.exception.KafkaClientException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicListing;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaSchemaRegistryValidator implements KafkaValidator {

    private final KafkaConfiguration kafkaConfiguration;

    private final RetryTemplate retryTemplate;

    private final AdminClient adminClient;

    public void validate() {
        retryTemplate.execute(this::checkSchemaRegistry);
    }

    private boolean checkSchemaRegistry(final RetryContext retryContext) {
        final Set<String> topicNamesToCreate = kafkaConfiguration.getTopicNamesToCreate();
        final Set<String> topicNames = getTopics();

        final boolean allTopicCreated = topicNames.containsAll(topicNamesToCreate);

        if (!allTopicCreated) {
            throw new KafkaClientException("Not all topics created");
        }

        return true;
    }

    private Set<String> getTopics() {
        try {
            return retryTemplate.execute(this::doGetTopic);
        } catch (Exception e) {
            throw new KafkaClientException("Couldn't get topics", e);
        }
    }

    private Set<String> doGetTopic(final RetryContext retryContext) throws ExecutionException, InterruptedException {
        log.info("Loading topics in attempt: <{}>", retryContext.getRetryCount());

        final Collection<TopicListing> topics = adminClient.listTopics()
                .listings()
                .get();

        if (topics == null) {
            log.info("Couldn't find any topics.");
            return Set.of();
        }

        final Set<String> topicNames = topics.stream()
                .map(TopicListing::name)
                .collect(Collectors.toSet());
        log.info("Loading topics completed: [{}]", topicNames);

        return topicNames;
    }

}
