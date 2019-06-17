package com.uol.clientrest.config;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.web.client.RestTemplate;

import com.uol.clientrest.presistence.dao.TemperaturaDAO;
import com.uol.clientrest.listener.ClimaListener;

@Configuration
public class RedisConfiguration {

	@Autowired
	private ClimaListener climaListener;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	RedisMessageListenerContainer container() {
		RedisMessageListenerContainer redisContainer = new RedisMessageListenerContainer();
		redisContainer.setConnectionFactory(jedisConnectionFactory());
		redisContainer.addMessageListener(messageListener(), topic());
		redisContainer.setTaskExecutor(Executors.newFixedThreadPool(4));
		return redisContainer;
	}

	@Bean
	MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(climaListener);
	}
	
	@Bean
	ChannelTopic topic() {
		return new ChannelTopic("pubsub:clima");
	}

	@Bean
	RedisTemplate<TemperaturaDAO, Object> redisTemplate() {
		final RedisTemplate<TemperaturaDAO, Object> template = new RedisTemplate<TemperaturaDAO, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

}
