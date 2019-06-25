package com.wrb.csi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.UserDao;
import com.wrb.csi.model.User;
import com.wrb.csi.service.RedisService;
import com.wrb.csi.service.UserService;
import com.wrb.csi.util.MD5Util;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisService redisService;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		String key = "user_" + id;
		redisService.delete(key);
		redisService.delete("users");
		return userDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		redisService.delete("users");
		return userDao.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		redisService.delete("users");
		return userDao.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		String key = "user_" + id;
		if (redisService.hasKey(key)) {
			User user = (User) redisService.get(key);
			return user;
		}

		User user = userDao.selectByPrimaryKey(id);
		redisService.set(key, user);
		return user;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		String key = "user_" + record.getId();
		redisService.set(key, record);
		redisService.delete("users");
		return userDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		String key = "user_" + record.getId();
		redisService.set(key, record);
		redisService.delete("users");
		return userDao.updateByPrimaryKey(record);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUsers() {
		String key = "users";
		if (redisService.hasKey(key)) {
			List<User> users = (List<User>) redisService.get(key);
			return users;
		}

		List<User> users = userDao.selectAllUsers();
		redisService.set(key, users);
		return users;
	}

	@Override
	public User selectByLoginName(String loginname) {
		return userDao.selectByLoginName(loginname);
	}

	@Override
	public User login(String loginname, String password) {
		User user = selectByLoginName(loginname);
		if(user == null) return null;
		if (user.getPassword().equals(MD5Util.string2MD5(password)))
			return user;
		return null;
	}

	@Override
	public List<User> seacherUser(String username, String status) {
		List<User> users = this.selectAllUsers();
		List<User> result = new ArrayList<User>();
		if (username != null && username.compareTo("") != 0) {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUsername().compareTo(username) == 0) {
					result.add(users.get(i));
				}
			}
		}
		else {
			result.addAll(users);
		}
		users.clear();
		if (status.compareTo("1")==0 || status.compareTo("2")==0) {
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).getStatus()==Integer.valueOf(status)) {
					users.add(result.get(i));
				}
			}
			
		}
		else {
			users.addAll(result);
		}
		return users;
	}

}
