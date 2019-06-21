package com.wrb.csi.service;

import java.util.List;

import com.wrb.csi.model.User;

public interface UserService {
   public User selectUserById(Integer userId); 
   public List<User> findAllUser();
}
