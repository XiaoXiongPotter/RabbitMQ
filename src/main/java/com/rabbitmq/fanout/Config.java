package com.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public Queue queue1(){
		return new Queue("xiaoxiong.potter");
	}
	
	@Bean
	public Queue queue2(){
		return new Queue("xiaoxiong.harry");
	}
	
	@Bean
	public FanoutExchange fanoutExchange(){
		return new FanoutExchange("fanoutExchanges");	
	}
	@Bean
	public Binding fanoutBinding(){
		return BindingBuilder.bind(queue1()).to(fanoutExchange());
	}
	@Bean
	public Binding fanoutBinding1(){
		return BindingBuilder.bind(queue2()).to(fanoutExchange());
	}
}
