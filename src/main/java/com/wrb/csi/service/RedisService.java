package com.wrb.csi.service;

public interface RedisService {
	void set(String key, Object value);
	Object get(String key);
	void delete(String key);
	boolean hasKey(String key);
}
