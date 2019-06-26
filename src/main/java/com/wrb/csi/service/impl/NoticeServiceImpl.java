package com.wrb.csi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.NoticeDao;
import com.wrb.csi.dao.UserDao;
import com.wrb.csi.model.Notice;
import com.wrb.csi.service.NoticeService;
import com.wrb.csi.service.RedisService;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private UserDao userDao;
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
		for(int i=0;i<notices.size();i++) {
			notices.get(i).setUserName(userDao.selectByPrimaryKey(notices.get(i).getUserid()).getUsername());
		}
		redisService.set(key, notices);
		return notices;
	}

	@Override
	public List<Notice> searchNotices(String title, String content) {
		List<Notice> notices = (List<Notice>) this.selectAllNotices();
		List<Notice> result = new ArrayList<Notice>();
		if (title != null && title.compareTo("") != 0) {
			for (int i = 0; i < notices.size(); i++) {
				if (notices.get(i).getTitle().compareTo(title) == 0) {
					result.add(notices.get(i));
				}
			}
		}
		else {
			result.addAll(notices);
		}
		notices.clear();
		if (content!=null && content.compareTo("")!=0) {
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).getContent().compareTo(content)==0) {
					notices.add(result.get(i));
				}
			}
			
		}
		else {
			notices.addAll(result);
		}
		return notices;
	}
}
