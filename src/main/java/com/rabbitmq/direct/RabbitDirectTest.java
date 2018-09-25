package com.rabbitmq.direct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.RabbitMQApplication;

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RabbitMQApplication.class)
public class RabbitDirectTest {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	@Test
	public void sendHelloTest() {
        String context = "此消息在，默认的交换机模式队列下，有 helloReceiver 可以收到";
        String routeKey = "hello";
        context = "routeKey:" + routeKey + ",context:" + context;
        System.out.println("sendHelloTest : " + context);
        this.rabbitTemplate.convertAndSend(routeKey, context);
    }  
}
