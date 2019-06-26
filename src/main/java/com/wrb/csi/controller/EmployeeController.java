package com.wrb.csi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrb.csi.model.Dept;
import com.wrb.csi.model.Employee;
import com.wrb.csi.model.User;
import com.wrb.csi.service.EmployeeService;
import com.wrb.csi.service.UserService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping(value="/employee/addEmployee",method = {RequestMethod.POST, RequestMethod.GET})
    public String  addEmployee(HttpServletRequest request, HttpSession session){
		String name = request.getParameter("name");
		String cardId = request.getParameter("cardId");
		String sex = request.getParameter("sex");
		String job_id = request.getParameter("job_id"); //职位id
		String education = request.getParameter("education");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String tel = request.getParameter("tel");
		String party = request.getParameter("party");
		String qqNum = request.getParameter("qqNum");
		String address = request.getParameter("address");
		String postCode = request.getParameter("postCode");
		String birthday = request.getParameter("birthday");
		String race = request.getParameter("race");
		String speciality = request.getParameter("speciality");
		String hobby = request.getParameter("hobby");
		String remark = request.getParameter("remark");
		String dept_id = request.getParameter("dept_id"); //部门id
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birth;
		try {
			birth = sdf.parse(birthday);
			Employee employee=new Employee(Integer.valueOf(dept_id), Integer.valueOf(job_id), name, cardId, address, postCode, tel, phone, qqNum, email, Integer.valueOf(sex), party, birth, race, education, speciality, hobby, remark, new Date());
			service.insert(employee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		session.setAttribute("datas", service.selectAllEmployees());
		return "employee/employee";
	}
	@RequestMapping(value="/employee/searchEmployee",method = {RequestMethod.POST, RequestMethod.GET})
    public String searchEmployee(HttpServletRequest request, HttpSession session){
		String job_id = request.getParameter("job_id");
		String name = request.getParameter("name");
		String cardId = request.getParameter("cardId");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String dept_id = request.getParameter("dept_id");
		List<Employee> employees=service.searchEmployees(job_id, name, cardId, sex, phone, dept_id);
		session.setAttribute("datas", employees);
		return "employee/employee";
	}
	
	@RequestMapping(value = "/employee/searchEmployees", method = { RequestMethod.POST, RequestMethod.GET })
	public String AllEmployee(HttpServletRequest request, HttpSession session) {
		List<Employee> Employee = service.selectAllEmployees();
		session.setAttribute("datas", Employee);
		return "employee/employee";
	}
	
	
	@RequestMapping(value="/employee/delemp",method = {RequestMethod.POST, RequestMethod.GET})
    public String delemp(HttpServletRequest request, HttpSession session){
		String[] ids = request.getParameterValues("check");
		for(int i=0;i<ids.length;i++) {
			System.out.println(ids[i]);
			service.deleteByPrimaryKey(Integer.valueOf(ids[i]));
		}
		session.setAttribute("datas", service.selectAllEmployees());
		
		return "employee/employee";
	}
	
	
	@RequestMapping(value="/employee/getEmployee",method = {RequestMethod.POST, RequestMethod.GET})
    public String getEmployee(HttpServletRequest request, HttpSession session){
		String id = request.getParameter("id");
		System.out.println(id);
		session.setAttribute("temp",service.selectByPrimaryKey(Integer.valueOf(id)));
		return "employee/showUpdateEmployee";
	}

	
	@RequestMapping(value="/employee/employeeForm",method = {RequestMethod.POST, RequestMethod.GET})
    public String employeeForm(HttpServletRequest request, HttpSession session){
		String name = request.getParameter("name");
		String cardId = request.getParameter("cardId");
		String sex = request.getParameter("sex");
		String job_id = request.getParameter("job_id"); //职位id
		String education = request.getParameter("education");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String tel = request.getParameter("tel");
		String party = request.getParameter("party");
		String qqNum = request.getParameter("qqNum");
		String address = request.getParameter("address");
		String postCode = request.getParameter("postCode");
		String birthday = request.getParameter("birthday");
		String race = request.getParameter("race");
		String speciality = request.getParameter("speciality");
		String hobby = request.getParameter("hobby");
		String remark = request.getParameter("remark");
		String dept_id = request.getParameter("dept_id"); //部门id
		String id = request.getParameter("id"); 
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birth;
		try {
			birth = sdf.parse(birthday);
			Employee employee=new Employee(Integer.valueOf(dept_id), Integer.valueOf(job_id), name, cardId, address, postCode, tel, phone, qqNum, email, Integer.valueOf(sex), party, birth, race, education, speciality, hobby, remark, new Date());
			employee.setId(Integer.valueOf(id));
			service.updateByPrimaryKey(employee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		session.setAttribute("datas", service.selectAllEmployees());
		return "employee/employee";
	}
}
