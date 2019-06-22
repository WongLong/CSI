package com.wrb.csi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.NoticeDao;
import com.wrb.csi.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
    private NoticeDao noticeDao;
	@Autowired
	private RedisTemplate redisTemplate;
}
