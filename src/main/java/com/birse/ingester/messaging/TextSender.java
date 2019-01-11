package com.birse.ingester.messaging;

import com.birse.ingester.domain.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TextSender {

    private static final Logger LOG = LoggerFactory.getLogger(TextSender.class);

    @Autowired
    private KafkaTemplate<Long, Text> kafkaTemplate;

    @Value("${app.topic.text}")
    private String topic;

    public void send(Text message) {
        LOG.info("sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
