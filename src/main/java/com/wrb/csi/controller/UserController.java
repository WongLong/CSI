package com.wrb.csi.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrb.csi.model.User;
import com.wrb.csi.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login",method = {RequestMethod.POST, RequestMethod.GET})
    public String  login(HttpServletRequest request, HttpSession session){
		String username = request.getParameter("loginname");
		String password = request.getParameter("password");
//		User user = service.selectByName(username);
//		System.out.println(user.getPassword());
        return "main";
    }
}
