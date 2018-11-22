package com.gmail.ramawthar.priyash.rabbit;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {


    static final String topicExchangeName = "budget-exchange";
    static final String queueName = "fnb-transactions";
    static final String routingKey = "fnb.trxn.#";
    
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("172.18.0.2");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("budget");
		connectionFactory.setPassword("fnbTrxn");
		return connectionFactory;
	}
	
	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		//The routing key is set to the name of the queue by the broker for the default exchange.
		//template.setRoutingKey(this.helloWorldQueueName);
		template.setExchange(topicExchangeName);
		template.setRoutingKey(routingKey);
		//Where we will synchronously receive messages from
		//template.setQueue(this.helloWorldQueueName);
		//System.out.println("Register the rabbitTemplate");
		return template;
	}

	//@Bean
	// Every queue is bound to the default direct exchange
	//public Queue queue() {
    //    return new Queue(queueName, false);
    //}
}
