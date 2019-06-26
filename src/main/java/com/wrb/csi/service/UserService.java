package com.wrb.csi.service;

import java.util.List;

import com.wrb.csi.model.User;
import com.wrb.csi.model.User.SearchUserMessage;

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
    List<User> seacherUser(SearchUserMessage message, int currentPage, int pageSize);
    List<User> selectUserOnPage(int currentPage, int pageSize);
	Integer getUserCount(SearchUserMessage message);
}
