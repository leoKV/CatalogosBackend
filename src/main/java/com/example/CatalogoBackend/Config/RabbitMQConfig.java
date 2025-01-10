package com.example.CatalogoBackend.Config;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	//Exchange
    public static final String CATALOG_EXCHANGE = "catalog.exchange";
	
	@Bean
	public Exchange catalogExchange() {
		return new TopicExchange(CATALOG_EXCHANGE);
	}
}
