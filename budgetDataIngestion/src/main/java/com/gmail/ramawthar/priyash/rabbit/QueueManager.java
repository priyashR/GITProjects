package com.gmail.ramawthar.priyash.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/////Doesnt seem to autowire

@Component
public class QueueManager {    
	@Autowired
    private RabbitTemplate rabbitTemplate;

	public QueueManager() {
		super();
	}
	
	public void sendRabbit(String result){
		rabbitTemplate.convertAndSend("budget-exchange", "fnb.trxn.#", "Hello from RabbitMQ!");
		
	}
    
}
