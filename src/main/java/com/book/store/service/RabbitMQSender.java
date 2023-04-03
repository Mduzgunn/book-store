package com.book.store.service;

import com.book.store.dto.request.CreateBookRequest;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    private final AmqpTemplate amqpTemplate;

    public RabbitMQSender(AmqpTemplate rabbitTemplate) {
        this.amqpTemplate = rabbitTemplate;
    }

    @Value("${book.rabbitmq.exchange}")
    private String exchange;

    @Value("${book.rabbitmq.routingkey}")
    private String routingkey;

    public void sendBookToQueue(CreateBookRequest createBookRequest) {
        amqpTemplate.convertAndSend(exchange, routingkey, createBookRequest);
        LOGGER.info("Book sent to queue. Book Title: {}, Book Cost: {}",
                createBookRequest.getTitle(), createBookRequest.getCost());
    }
}
