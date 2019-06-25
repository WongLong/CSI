package com.wrb.csi.service;

import java.util.List;

import com.wrb.csi.model.User;

public interface UserService {
	int deleteByPrimaryKey(Integer id);
	int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
    List<User> selectAllUsers();
    User login(String loginname, String password);
    User selectByLoginName(String loginname);
    List<User> seacherUser(String username, String status);
    List<User> selectUserOnPage(int currentPage, int pageSize);
}
