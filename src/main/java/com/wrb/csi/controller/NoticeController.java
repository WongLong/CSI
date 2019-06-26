package com.wrb.csi.controller;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrb.csi.model.Notice;
import com.wrb.csi.model.User;
import com.wrb.csi.service.NoticeService;



@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value="/notice/selectAllNotices",method = {RequestMethod.POST, RequestMethod.GET})
	public String selectAllNotices(HttpServletRequest request, HttpSession session) {
		List<Notice> notices=service.selectAllNotices();
		session.setAttribute("datas", notices);
		return "notice/notice";
	}
	
	@RequestMapping(value="/notice/searchNotices",method = {RequestMethod.POST, RequestMethod.GET})
	public String searchNotices(HttpServletRequest request, HttpSession session) {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		List<Notice> notices=service.searchNotices(title, content);
		session.setAttribute("datas", notices);
		return "notice/notice";
	}
	
	@RequestMapping(value="/notice/addNotice",method = {RequestMethod.POST, RequestMethod.GET})
	public String addNotice(HttpServletRequest request, HttpSession session) {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Integer userid=((User)session.getAttribute("loginedUser")).getId();
		Notice notice=new Notice(title,content,new Date(),userid);
		service.insert(notice);
		session.setAttribute("datas", service.selectAllNotices());
		return "notice/notice";
	}
	
	@RequestMapping(value="/notice/deleteNotices",method = {RequestMethod.POST, RequestMethod.GET})
	public String deleteNotices(HttpServletRequest request, HttpSession session) {
		String[] ids=request.getParameterValues("checked");
		for(int i=0;i<ids.length;i++) {
			service.deleteByPrimaryKey(Integer.valueOf(ids[i]));
		}
		session.setAttribute("datas", service.selectAllNotices());
		return "notice/notice";
	}
	
	@RequestMapping(value="/notice/previewNotice",method = {RequestMethod.POST, RequestMethod.GET})
	public String previewNotice(HttpServletRequest request, HttpSession session) {
		String id=request.getParameter("id");
		Notice notice=service.selectByPrimaryKey(Integer.valueOf(id));
		session.setAttribute("temp", notice);
		return "notice/previewNotice";
	}
	
	@RequestMapping(value="/notice/getNotice",method = {RequestMethod.POST, RequestMethod.GET})
	public String getNotice(HttpServletRequest request, HttpSession session) {
		String id=request.getParameter("id");
		Notice notice=service.selectByPrimaryKey(Integer.valueOf(id));
		session.setAttribute("temp", notice);
		return "notice/showUpdateNotice";
	}
	
	@RequestMapping(value="/notice/updateNotice",method = {RequestMethod.POST, RequestMethod.GET})
	public String updateNotice(HttpServletRequest request, HttpSession session) {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Integer userid=((User)session.getAttribute("loginedUser")).getId();
		String id=request.getParameter("id");
		Notice temp=new Notice(title,content,new Date(),userid);
		temp.setId(Integer.valueOf(id));
		service.updateByPrimaryKey(temp);
		session.setAttribute("datas", service.selectAllNotices());
		return "notice/notice";
	}
}
