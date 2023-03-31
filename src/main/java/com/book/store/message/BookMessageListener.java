package com.book.store.message;

import com.book.store.dto.request.CreateBookRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BookMessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookMessageListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveMessage(CreateBookRequest createBookRequest) {
        LOGGER.info("New book added with id: {} and name: {}", createBookRequest.getTitle(), createBookRequest.getCost());
    }
}
