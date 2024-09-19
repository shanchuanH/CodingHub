package com.example.codinghub.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class RabbitMQSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendPraiseNotification(String articleId, String userId) {
        log.info("Sending praise notification for article {} by user {}", articleId, userId);
        String message = String.format("Article %s was praised by user %s", articleId, userId);
        rabbitTemplate.convertAndSend("articleExchange", "praiseNotification", message);
    }
}
