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

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String login(HttpServletRequest request, HttpSession session) {
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
//		User user = service.selectByName(username);
//		System.out.println(user.getPassword());
		User user1 = new User("1", "123", 1, new Date(), "1");
		User user2 = new User("1", "123", 2, new Date(), "1");
		User user3 = new User("1", "123", 2, new Date(), "1");
		User user4 = new User("1", "123", 1, new Date(), "1");
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		session.setAttribute("loginname", loginname);
		session.setAttribute("users", users);

		return "main";
	}

	@RequestMapping(value = "/user/searchUser", method = { RequestMethod.POST, RequestMethod.GET })
	public String seacherUser(HttpServletRequest request, HttpSession session) {
		System.out.println("++++++++++++++++++++++++++++");
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
