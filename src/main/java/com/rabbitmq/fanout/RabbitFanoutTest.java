package com.rabbitmq.fanout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rabbitmq.RabbitMQApplication;

@SpringBootTest(classes=RabbitMQApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitFanoutTest {

	@Autowired
	 private AmqpTemplate rabbitTemplate;
	    @Test
	    public void sendPengleiTest() {

	        String context = "此消息在，广播模式或者订阅模式队列下，有 FanoutReceiver1 FanoutReceiver2 可以收到";

	        //routekey可以是任何，但是必须要有，exchange也是
	        String routeKey = "text"; //"topic.penglei.net";

	        String exchange = "fanoutExchanges";

	        System.out.println("sendPengleiTest : " + context);

	        context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;
	        //只需要自定义一个叫exchange就行
	        this.rabbitTemplate.convertAndSend(exchange, "", context);
	    }   
}
