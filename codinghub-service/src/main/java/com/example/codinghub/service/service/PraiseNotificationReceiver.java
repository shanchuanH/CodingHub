package com.example.codinghub.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PraiseNotificationReceiver {

    @RabbitListener(queues = "praiseQueue")
    public void receiveMessage(String message) {
        log.info("Received praise notification: {}", message);
        // Additional processing logic can be implemented here
    }
}
