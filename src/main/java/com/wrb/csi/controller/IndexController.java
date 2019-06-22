package com.wrb.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	  @RequestMapping("/loginForm")
	    public String  index2(){
	        return "loginForm";
	    }
	  @RequestMapping("/main")
	    public String  index1(){
	        return "main";
	    }
	  
	  @RequestMapping("/editPassword")
	    public String  index0(){
	        return "editPassword/editPassword";
	    }
	  
	  @RequestMapping("/face")
	    public String  index10(){
	        return "user/face";
	    }
	  @RequestMapping("user/user")
	    public String  index11(){
	        return "user/user";
	    }
	  
	  @RequestMapping("user/showAddUser")
	    public String  index12(){
	        return "user/showAddUser";
	    }
	  
	  @RequestMapping("user/showUpdateUser")
	    public String  index123(){
	        return "user/showUpdateUser";
	    }
	  
	  @RequestMapping("document/document")
	    public String  index13(){
	        return "document/document";
	    }
	  
	  @RequestMapping("document/showUpdateDocument")
	    public String  index14(){
	        return "document/showUpdateDocument";
	    }
	  
	  @RequestMapping("document/showAddDocument")
	    public String  index19(){
	        return "document/showAddDocument";
	    }
	  
	  
	  @RequestMapping("employee/showAddEmployee")
	    public String  index191(){
	        return "employee/showAddEmployee";
	    }
	  
	  @RequestMapping("employee/showUpdateEmployee")
	    public String  index192(){
	        return "employee/showUpdateEmployee";
	    }
	  
	  @RequestMapping("employee/employee")
	    public String  index1942(){
	        return "employee/employee";
	    }
	  
	  
	  @RequestMapping("dept/showUpdateDept")
	    public String  index193(){
	        return "dept/showUpdateDept";
	    }
	  
	  @RequestMapping("dept/dept")
	    public String  index1931(){
	        return "dept/dept";
	    }
	  
	  @RequestMapping("dept/showAddDept")
	    public String  index194(){
	        return "dept/showAddDept";
	    }
	  
	  @RequestMapping("job/job")
	    public String  index195(){
	        return "job/job";
	    }
	  
	  @RequestMapping("job/showAddJob")
	    public String  index196(){
	        return "job/showAddJob";
	    }
	  
	  @RequestMapping("job/showUpdateJob")
	    public String  index197(){
	        return "job/showUpdateJob";
	    }
	  
	  @RequestMapping("notice/notice")
	    public String  index198(){
	        return "notice/notice";
	    }
	  
	  @RequestMapping("notice/previewNotice")
	    public String  index199(){
	        return "notice/previewNotice";
	    }
	  
	  @RequestMapping("notice/showAddNotice")
	    public String  index1999(){
	        return "notice/showAddNotice";
	    }
	  
	  @RequestMapping("notice/showUpdateNotice")
	    public String  index1990(){
	        return "notice/showUpdateNotice";
	    }
}
