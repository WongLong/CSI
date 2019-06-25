package com.wrb.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wrb.csi.model.Dept;
import com.wrb.csi.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/")
    public String  index(){
        return "";
    }
	
	@RequestMapping("/delDept")
    public String  delDept(){
		
        return "true";
    }
	
	@RequestMapping("/findAllDept")
    public List<Dept>  findAllDept(){
        return deptService.selectAllDepts();
    }
	
	@RequestMapping("/insertDept")
    public String  insertDept(){
        return "true";
    }
	
	@RequestMapping("/updateDept")
    public String  updateDept(){
        return "true";
    }
}
