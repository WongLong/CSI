package com.wrb.csi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.DocumentDao;
import com.wrb.csi.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private DocumentDao documentDao;
	@Autowired
	private RedisTemplate redisTemplate;
}
