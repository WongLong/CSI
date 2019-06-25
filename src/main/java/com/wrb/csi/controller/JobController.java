package com.wrb.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {
	@RequestMapping("/c")
    public String  index(){
        return "";
    }
}
