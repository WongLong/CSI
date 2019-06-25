package com.wrb.csi.controller;

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
import com.wrb.csi.util.MD5Util;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	private final int pageSize = 10;

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String login(HttpServletRequest request, HttpSession session) {
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		User u = service.login(loginname, password);
		if (u != null) {
			session.setAttribute("loginedUser", u);
			List<User> users = service.selectAllUsers();
			int totalPage = users.size() / pageSize +  users.size() % pageSize > 0 ? 1 : 0 ;
			int currentPage = 1;
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("datas", service.selectUserOnPage(currentPage, pageSize));
			return "main";
		}

		return "loginForm";
	}

	@RequestMapping(value = "/user/insertAndUpdateUser", method = { RequestMethod.POST, RequestMethod.GET })
	public String insertUser(HttpServletRequest request, HttpSession session) {
		User loginedUser = (User) session.getAttribute("loginedUser");
		if (loginedUser.getStatus() == 1) {
			Integer flag = Integer.parseInt(request.getParameter("flag"));
			if (flag == 1) {
				String loginname = request.getParameter("loginname");
				String password = request.getParameter("password");
				String username = request.getParameter("username");
				Integer status = Integer.parseInt(request.getParameter("status"));
				service.insert(new User(loginname, password, status, new Date(), username));
				session.setAttribute("datas", service.selectAllUsers());
			} else {
				User temp = (User) session.getAttribute("temp");
				String loginname = request.getParameter("loginname");
				String username = request.getParameter("username");
				Integer status = Integer.parseInt(request.getParameter("status"));
				temp.setLoginname(loginname);
				temp.setUsername(username);
				temp.setStatus(status);
				service.updateByPrimaryKey(temp);
				session.removeAttribute("temp");
				session.setAttribute("datas", service.selectAllUsers());
			}
		}
		return "user/user";
	}

	@RequestMapping(value = "/user/searchUser", method = { RequestMethod.POST, RequestMethod.GET })
	public String seacherUser(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String status = request.getParameter("status");
		List<User> users = service.seacherUser(username, status);
		session.setAttribute("datas", users);
		return "user/user";
	}

	@RequestMapping(value = "/changePassword", method = { RequestMethod.POST, RequestMethod.GET })
	public String changePassword(HttpServletRequest request, HttpSession session) {
		String newPassword = request.getParameter("newPassword").trim();
		String newPasswordCon = request.getParameter("newPasswordCon").trim();
		String oldPassword = request.getParameter("oldPassword").trim();
		User u = (User) session.getAttribute("loginedUser");

		if (!newPassword.equals(newPasswordCon)) {
			request.setAttribute("changePasswordError", "新密码与确认密码必须保持一致");
			return "editPassword/editPassword";
		} else if (!u.getPassword().equals(MD5Util.string2MD5(oldPassword))) {
			request.setAttribute("changePasswordError", "当前密码错误");
			return "editPassword/editPassword";
		}

		u.setPassword(MD5Util.string2MD5(newPasswordCon));
		service.updateByPrimaryKey(u);
		return "editPassword/successful";
	}

	@RequestMapping(value = "/loginOut", method = { RequestMethod.POST, RequestMethod.GET })
	public String loginOut(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "loginForm";
	}

	@RequestMapping(value = "/user/removeUser", method = { RequestMethod.POST, RequestMethod.GET })
	public String removeUser(HttpServletRequest request, HttpSession session) {
		User loginedUser = (User) session.getAttribute("loginedUser");
		if (loginedUser.getStatus() == 1) {
			String[] ids = request.getParameter("ids").trim().split(",");
			for (String id : ids) {
				service.deleteByPrimaryKey(Integer.parseInt(id));
			}
		}
		session.setAttribute("datas", service.selectAllUsers());
		return "user/user";
	}

	@RequestMapping(value = "/user/toUpdateUser", method = { RequestMethod.POST, RequestMethod.GET })
	public String toUpdateUser(HttpServletRequest request, HttpSession session) {
		Integer tempId = Integer.parseInt(request.getParameter("tempId"));
		User u = service.selectByPrimaryKey(tempId);
		session.setAttribute("temp", u);
		return "user/showUpdateUser";
	}
}
