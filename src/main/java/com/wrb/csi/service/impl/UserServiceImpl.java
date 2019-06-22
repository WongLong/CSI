package com.wrb.csi.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.UserDao;
import com.wrb.csi.model.User;
import com.wrb.csi.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	  @Autowired
	  private UserDao userDao;
	  
	  @Autowired
	  private RedisTemplate redisTemplate;
	  
//	  @Override
//	  public List<User> findAllUser() { 
//		  String key = "user";
//		  ValueOperations<String, List<User>> operations = redisTemplate.opsForValue();
//		  boolean hasKey = redisTemplate.hasKey(key); 
//		  if (hasKey) { 
//			  List<User> users =operations.get(key); 
//			  System.out.println("从Redis中获取Users");
//		  
//		  return users; }
//	  
//	  List<User> users = userDao.findAllUser(); 
//	  operations.set(key, users, 10, TimeUnit.SECONDS); 
//	  System.out.println("将users存入Redis缓存");
//	  return users; 
//	  }
}
