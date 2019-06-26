package com.wrb.csi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.wrb.csi.model.Dept;
import com.wrb.csi.model.Job;
import com.wrb.csi.service.DeptService;
import com.wrb.csi.service.JobService;

@Controller
public class DeptController {
	@Autowired
	private DeptService Service;

	@RequestMapping(value = "/dept/searchDept", method = { RequestMethod.POST, RequestMethod.GET })
	public String seacherDept(HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("searchDeptname");
		List<Dept> Depts = Service.selectAllDepts();
		List<Dept> result = new ArrayList<Dept>();
		if (name == null || name.compareTo("") == 0) {
			session.setAttribute("datas", Depts);
		} else {
			for (int i = 0; i < Depts.size(); i++) {
				if (Depts.get(i).getName().compareTo(name) == 0)
					result.add(Depts.get(i));
			}
			session.setAttribute("datas", result);
		}
		return "dept/dept";
	}

	@RequestMapping(value = "/dept/insertDept", method = { RequestMethod.POST, RequestMethod.GET })
	public String addDept(HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("name");
		String remark = request.getParameter("remark");
		Dept Dept = new Dept(name, remark);
		Service.insert(Dept);
		List<Dept> Depts = Service.selectAllDepts();
		session.setAttribute("datas", Depts);
		return "dept/dept";
	}

	@RequestMapping(value = "/dept/delDept", method = { RequestMethod.POST, RequestMethod.GET })
	public String delDept(HttpServletRequest request, HttpSession session) {
		String[] select = request.getParameterValues("check");
		for (int i = 0; i < select.length; i++) {
			Service.deleteByPrimaryKey(Integer.valueOf(select[i]));
		}
		List<Dept> Depts = Service.selectAllDepts();
		session.setAttribute("datas", Depts);
		return "dept/dept";
	}
	
	@RequestMapping(value = "/dept/AllDept", method = { RequestMethod.POST, RequestMethod.GET })
	public String AllDept(HttpServletRequest request, HttpSession session) {
		List<Dept> Depts = Service.selectAllDepts();
		session.setAttribute("datas", Depts);
		return "dept/dept";
	}
	
	@RequestMapping(value = "/dept/transmitId", method = { RequestMethod.POST, RequestMethod.GET })
	public String transmitId(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		Dept Dept=Service.selectByPrimaryKey(Integer.valueOf(id));
		session.setAttribute("job", Dept);
		return "Dept/showUpdateDept";
	}
	
	@RequestMapping(value = "/dept/getDept", method = { RequestMethod.POST, RequestMethod.GET })
	public String getDept(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		session.setAttribute("temp", Service.selectByPrimaryKey(Integer.valueOf(id)));
		return "dept/showUpdateDept";
	}	
	
	@RequestMapping(value = "/dept/changeDept", method = { RequestMethod.POST, RequestMethod.GET })
	public String changeDept(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String remark = request.getParameter("remark");
		Dept Dept=new Dept(name, remark);
		Dept.setId(Integer.valueOf(id));
		Service.updateByPrimaryKey(Dept);
		List<Dept> Depts = Service.selectAllDepts();
		session.setAttribute("datas", Depts);
		return "dept/dept";
	}	
}
