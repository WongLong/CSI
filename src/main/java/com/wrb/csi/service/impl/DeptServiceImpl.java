package com.wrb.csi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.DeptDao;
import com.wrb.csi.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private RedisTemplate redisTemplate;
}
