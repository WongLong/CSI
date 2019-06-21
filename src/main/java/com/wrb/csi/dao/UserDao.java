package com.wrb.csi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wrb.csi.model.User;

@Mapper
public interface UserDao {  
    public User selectUserById(Integer userId);  
    public List<User> findAllUser();
} 
