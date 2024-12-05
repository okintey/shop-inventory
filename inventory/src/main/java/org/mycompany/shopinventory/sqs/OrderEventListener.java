package org.mycompany.shopinventory.sqs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventListener {

    private final ObjectMapper objectMapper;

    @SqsListener("${org.mycompany.shopinventory.aws.sqs.queueName}")
    public void processOrderEvent(String message) {
        try {
            OrderEvent orderEvent = objectMapper.readValue(message, OrderEvent.class);
            log.info("Received orderEvent: " + orderEvent);
        } catch (JsonProcessingException e) {
            log.error("Error parsing orderEvent: " + message, e);
        }
    }
}
