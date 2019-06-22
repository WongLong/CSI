package com.wrb.csi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
	@RequestMapping("/a")
    public String  index(){
        return "";
    }
}
