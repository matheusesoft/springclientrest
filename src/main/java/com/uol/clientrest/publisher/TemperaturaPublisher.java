package com.uol.clientrest.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.uol.clientrest.presistence.dao.TemperaturaDAO;

@Service
public class TemperaturaPublisher {

	@Autowired
	private RedisTemplate<TemperaturaDAO, Object> redisTemplate;

	@Autowired
	private ChannelTopic topic;

	public void publish(TemperaturaDAO temperaturaDAO) {
		redisTemplate.convertAndSend(topic.getTopic(), temperaturaDAO);
	}

}
