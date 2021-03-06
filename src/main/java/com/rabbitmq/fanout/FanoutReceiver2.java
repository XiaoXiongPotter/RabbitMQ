package com.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="xiaoxiong.potter")
public class FanoutReceiver2 {

	@RabbitHandler
	 public void process(String message) {
        System.out.println("接收者 FanoutReceiver2," + message);
    }
	
}
