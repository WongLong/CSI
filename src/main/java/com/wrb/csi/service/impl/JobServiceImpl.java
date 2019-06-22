package com.wrb.csi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.JobDao;
import com.wrb.csi.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobDao jobDao;
	@Autowired
	private RedisTemplate redisTemplate;

}
