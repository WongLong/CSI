package com.wrb.csi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.wrb.csi.model.Dept;
import com.wrb.csi.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService service;
	
	@RequestMapping("/")
    public String  index(){
        return "";
    }
	
	@RequestMapping("/delDept")
    public String  delDept(){
		
        return "true";
    }
	
	@RequestMapping(value="/dept/dept",method = {RequestMethod.POST, RequestMethod.GET})
    public String findAllDept(HttpServletRequest request, HttpSession session){
		Dept dept = (Dept) session.getAttribute("");
		session.setAttribute("datas", service.selectAllDepts());
		return "dept/dept";
    }
	
	@RequestMapping("/dept/insertDept")
    public String  insertDept(){
		
        return "true";
    }
	
	@RequestMapping("/updateDept")
    public String  updateDept(){
        return "true";
    }
	
	@RequestMapping(value="/dept/searchDepts",method = {RequestMethod.POST, RequestMethod.GET})
    public String searchDept(HttpServletRequest request, HttpSession session){
		List<Dept> depts=service.selectAllDepts();
		Dept dept = new Dept();
		String name=request.getParameter("searchDeptname");		
		session.setAttribute("depts",service.searchDept(name));
		return "dept/dept";
    }
	
	
}
