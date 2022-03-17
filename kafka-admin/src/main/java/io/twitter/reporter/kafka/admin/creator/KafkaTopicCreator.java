package io.twitter.reporter.kafka.admin.creator;

import io.twitter.reporter.config.KafkaAdminProperties;
import io.twitter.reporter.kafka.admin.exception.KafkaClientException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaTopicCreator {

    private final KafkaAdminProperties adminProperties;

    private final RetryTemplate retryTemplate;

    private final AdminClient adminClient;

    public void createTopics() {
        final Set<String> topicNamesToCreate = adminProperties.getTopicNamesToCreate();
        log.info("Creating topics: [{}]", topicNamesToCreate);

        try {
            retryTemplate.execute(this::doCreateTopic);
        } catch (RuntimeException e) {
            throw new KafkaClientException(String.format("Couldn't create topics: [%s]", topicNamesToCreate), e);
        }
    }

    private CreateTopicsResult doCreateTopic(final RetryContext retryContext) {
        final Set<String> topicNamesToCreate = adminProperties.getTopicNamesToCreate();
        log.info("Creating topics: [{}] in attempt: <{}>", topicNamesToCreate, retryContext.getRetryCount());

        final List<NewTopic> newTopics = topicNamesToCreate.stream()
                .map(topicName -> new NewTopic(topicName.trim(),
                        adminProperties.getPartitionsCount(),
                        adminProperties.getReplicationFactor()))
                .collect(Collectors.toList());

        return adminClient.createTopics(newTopics);
    }

}
