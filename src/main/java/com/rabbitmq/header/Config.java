package com.rabbitmq.header;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Config {

	@Bean
	public Queue headerQueue(){
		return new Queue("xiaoxiong.header");
	}
	
	@Bean
	public HeadersExchange getHerderExchange(){
		return new HeadersExchange("headerExchange");
	}
	
	@Bean
	public Binding getBuilding(Queue headerQueue,HeadersExchange getHerderExchange){
		Map<String,Object> headerValues = new HashMap<>();
		headerValues.put("type", "cash");
//		headerValues.put("aging", "fast");
		return BindingBuilder.bind(headerQueue).to(getHerderExchange).whereAny(headerValues).match();
	}
}
