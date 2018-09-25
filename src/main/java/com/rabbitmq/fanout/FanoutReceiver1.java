package com.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="xiaoxiong.harry")
public class FanoutReceiver1 {

	@RabbitHandler
	 public void process(String message) {
        System.out.println("接收者 FanoutReceiver1," + message);
    }
	
}
