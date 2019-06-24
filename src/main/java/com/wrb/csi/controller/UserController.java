package com.wrb.csi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		User u = service.login(loginname, password);
		if(u != null) {
			session.setAttribute("loginedUser",u);
			session.setAttribute("users", service.selectAllUsers());
			return "main";
		}
		
		return "loginForm";
    }
	
	@RequestMapping(value="/insertUser",method = {RequestMethod.POST, RequestMethod.GET})
	public String insertUser(HttpServletRequest request, HttpSession session) {
		User loginedUser = (User) session.getAttribute("loginedUser");
		if(loginedUser.getStatus() == 1) {
			String loginname = request.getParameter("loginname");
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			Integer status = Integer.parseInt(request.getParameter("status"));
			service.insert(new User(loginname, password, status, new Date(), username));
		}
		
		return "main";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/searchUser", method = {RequestMethod.POST, RequestMethod.GET})
	public String seacherUser(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String status = request.getParameter("status");
		List<User> users = (List<User>) session.getAttribute("users");
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
		session.setAttribute("users", users);
		return "user/user";
	}
}
