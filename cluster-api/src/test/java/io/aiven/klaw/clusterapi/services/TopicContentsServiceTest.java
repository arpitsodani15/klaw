package io.aiven.klaw.clusterapi.services;

import io.aiven.klaw.clusterapi.utils.ClusterApiUtils;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TopicContentsServiceTest {
  @Mock private ClusterApiUtils clusterApiUtils;
  private TopicContentsService topicContentsService;

  @BeforeEach
  void setup() {
    topicContentsService = new TopicContentsService(clusterApiUtils);
  }

  @Test
  void readEvents() {
    String protocol = "SSL";
    String clusterName = "cluster_name";
    String topicName = "topic_name";
    int offsetPosition = 0;
    String readMessagesType = "OFFSET_ID";
    String consumerGroupId = "my-consumer-group";
    String bootstrapServers = "localhost:9092";
    String clusterIdentification = "my-cluster-identifier";

    Mockito.when(clusterApiUtils.getSslConfig(clusterIdentification)).thenReturn(new Properties());

    Map<Long, String> actual =
        topicContentsService.readEvents(
            bootstrapServers,
            protocol,
            clusterName,
            consumerGroupId,
            topicName,
            offsetPosition,
            readMessagesType,
            clusterIdentification);

    Map<Long, String> expected = Collections.emptyMap();
    Assertions.assertThat(actual).isEqualTo(expected);
  }
}
