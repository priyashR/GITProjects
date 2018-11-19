package com.gmail.ramawthar.priyash.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueueManager {
	
	public void publishToQueue(String msg){

		ApplicationContext context = new AnnotationConfigApplicationContext(QueueConfig.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		amqpTemplate.convertAndSend(msg);
		System.out.println("msg: "+msg);
	}

}
