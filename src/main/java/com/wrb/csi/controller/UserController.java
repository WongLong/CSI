package com.wrb.csi.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrb.csi.model.User;
import com.wrb.csi.model.User.SearchUserMessage;
import com.wrb.csi.service.UserService;
import com.wrb.csi.util.MD5Util;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	private final int pageSize = 10;

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		User u = service.login(loginname, password);
		if (u != null) {
			session.setAttribute("loginedUser", u);
			int userSize = service.getUserCount(null);
			int currentPage = 1;
			int totalPage = userSize / pageSize + (userSize % pageSize > 0 ? 1 : 0);
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
			}
			int userSize = service.getUserCount(null);
			int totalPage = userSize / pageSize + (userSize % pageSize > 0 ? 1 : 0);
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("currentPage", 1);
			session.removeAttribute("message");
			session.setAttribute("datas", service.selectUserOnPage(1, pageSize));
		}
		return "user/user";
	}

	@RequestMapping(value = "/user/searchUser", method = { RequestMethod.POST, RequestMethod.GET })
	public String seacherUser(HttpServletRequest request, HttpSession session) {
		Integer type = Integer.parseInt(request.getParameter("type"));
		SearchUserMessage message = session.getAttribute("message") == null ? new SearchUserMessage()
				: (SearchUserMessage) session.getAttribute("message");
		int currentPage = (int) session.getAttribute("currentPage");
		if (type == 1) {
			currentPage = currentPage - 1 < 1 ? 1 : currentPage - 1;
		} else if (type == 2) {
			int totalPage = (int) session.getAttribute("totalPage");
			currentPage = currentPage + 1 > totalPage ? totalPage : currentPage + 1;
		} else {
			String username = request.getParameter("username");
			Integer status = Integer.parseInt(request.getParameter("status"));
			message.setUsername(username);
			message.setStatus(status);
			currentPage = 1;
			Integer userSize = service.getUserCount(message);
			session.setAttribute("totalPage", userSize / pageSize + (userSize % pageSize > 0 ? 1 : 0));
			session.setAttribute("message", message);
		}

		session.setAttribute("currentPage", currentPage);
		session.setAttribute("datas", service.seacherUser(message, currentPage, pageSize));
		return "user/user";
	}

	@RequestMapping(value = "/user/jumpPage", method = { RequestMethod.POST, RequestMethod.GET })
	public String jumpPage(HttpServletRequest request, HttpSession session) {
		int totalPage = (int) session.getAttribute("totalPage");
		Integer page = Integer.parseInt(request.getParameter("page"));
		page = page < 1 ? 1 : page;
		page = page > totalPage ? totalPage : page;

		SearchUserMessage message = session.getAttribute("message") == null ? new SearchUserMessage()
				: (SearchUserMessage) session.getAttribute("message");
		session.setAttribute("currentPage", page);
		session.setAttribute("datas", service.seacherUser(message, page, pageSize));
		return "user/user";
	}
	
	
	@RequestMapping(value = "/user/AllUser", method = { RequestMethod.POST, RequestMethod.GET })
	public String AllEmployee(HttpServletRequest request, HttpSession session) {
		int userSize = service.getUserCount(null);
		int currentPage = 1;
		int totalPage = userSize / pageSize + (userSize % pageSize > 0 ? 1 : 0);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("datas", service.selectUserOnPage(currentPage, pageSize));
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
		int userSize = service.getUserCount(null);
		int totalPage = userSize / pageSize + (userSize % pageSize > 0 ? 1 : 0);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("currentPage", 1);
		session.removeAttribute("message");
		session.setAttribute("datas", service.selectUserOnPage(1, pageSize));
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
