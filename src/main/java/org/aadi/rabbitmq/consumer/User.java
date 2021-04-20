package org.aadi.rabbitmq.consumer;

import org.aadi.rabbitmq.config.MessagingConfig;
import org.aadi.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("message received from queue : "+orderStatus);
	}

}
