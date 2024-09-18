package com.example.codinghub.service.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RabbitMQSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendPraiseNotification(String articleId, String userId) {
        String message = String.format("Article %s was praised by user %s", articleId, userId);
        rabbitTemplate.convertAndSend("articleExchange", "praiseNotification", message);
    }
}
