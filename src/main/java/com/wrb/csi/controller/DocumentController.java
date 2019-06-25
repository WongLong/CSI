package com.wrb.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentController {
	@RequestMapping("/a")
    public String  index(){
        return "";
    }
}
