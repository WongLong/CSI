package com.wrb.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrb.csi.model.Dept;
import com.wrb.csi.service.DeptService;

@RestController
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
