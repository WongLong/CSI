package com.wrb.csi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.NoticeDao;
import com.wrb.csi.model.Notice;
import com.wrb.csi.service.NoticeService;
import com.wrb.csi.service.RedisService;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private RedisService redisService;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		String key = "notice_" + id;
		redisService.delete(key);
		redisService.delete("notices");
		return noticeDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Notice record) {
		redisService.delete("notices");
		return noticeDao.insert(record);
	}

	@Override
	public int insertSelective(Notice record) {
		redisService.delete("notices");
		return noticeDao.insertSelective(record);
	}

	@Override
	public Notice selectByPrimaryKey(Integer id) {
		String key = "notice_" + id;
		if (redisService.hasKey(key)) {
			Notice notice = (Notice) redisService.get(key);
			return notice;
		}

		Notice notice = noticeDao.selectByPrimaryKey(id);
		redisService.set(key, notice);
		return notice;
	}

	@Override
	public int updateByPrimaryKeySelective(Notice record) {
		String key = "notice_" + record.getId();
		redisService.set(key, record);
		redisService.delete("notices");
		return noticeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Notice record) {
		String key = "notice_" + record.getId();
		redisService.set(key, record);
		redisService.delete("notices");
		return noticeDao.updateByPrimaryKey(record);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> selectAllNotices() {
		String key = "notices";
		if (redisService.hasKey(key)) {
			List<Notice> notices = (List<Notice>) redisService.get(key);
			return notices;
		}

		List<Notice> notices = noticeDao.selectAllNotices();
		redisService.set(key, notices);
		return notices;
	}
}
