package com.wrb.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	  @RequestMapping("/loginForm")
	    public String  index2(ModelMap map){
	    	map.addAttribute("name","thymeleaf");
	        return "loginForm";
	    }
	  @RequestMapping("/main")
	    public String  index1(ModelMap map){
	    	map.addAttribute("name","thymeleaf");
	        return "main";
	    }
}
