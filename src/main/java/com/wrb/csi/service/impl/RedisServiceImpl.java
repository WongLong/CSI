package com.wrb.csi.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.wrb.csi.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value, 10, TimeUnit.SECONDS);
	}

	@Override
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void delete(String key) {
		redisTemplate.opsForValue().getOperations().delete(key);
	}

	@Override
	public boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}

}
