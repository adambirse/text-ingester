package com.birse.ingester.messaging;

import com.birse.ingester.KafkaProducerTest;
import com.birse.ingester.domain.Text;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class TextSenderTest extends KafkaProducerTest {
    @Autowired
    private TextSender sender;

    @Test
    public void testSend() throws InterruptedException {
        // send the message

        Text test = getTestProject();

        sender.send(test);

        // check that the message was received
        ConsumerRecord<Long, Text> received = records.poll(10, TimeUnit.SECONDS);
        // Hamcrest Matchers to check the value
        assertThat(received.value(), samePropertyValuesAs(test));
    }

    private Text getTestProject() {
        return new Text("Test");
    }

}
