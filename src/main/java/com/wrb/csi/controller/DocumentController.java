package com.wrb.csi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrb.csi.model.Document;
import com.wrb.csi.model.Job;
import com.wrb.csi.model.User;
import com.wrb.csi.service.DocumentService;
import com.wrb.csi.service.UserService;

@Controller
public class DocumentController {
	@Autowired
	private DocumentService documentService;
	
	
	@RequestMapping(value = "/document/searchDocument", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchDocument(HttpServletRequest request, HttpSession session) {
		String title = request.getParameter("title");
		List<Document> datas=documentService.selectAllDocuments();
		if(title==null||title.compareTo("")==0)
		{
			session.setAttribute("datas", datas);
		}
		else
		{	
			List<Document> result=new ArrayList<Document>();
			for(int i=0;i<datas.size();i++)
			{
				if(datas.get(i).getTitle().compareTo(title)==0)
					result.add(datas.get(i));
			}
			session.setAttribute("datas", result);
		}
		System.out.println("嘟嘟嘟嘟嘟嘟");
		return "document/document";
	}
	
	@RequestMapping(value = "/document/transmitId", method = { RequestMethod.POST, RequestMethod.GET })
	public String transmitId(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		Document document=documentService.selectByPrimaryKey(Integer.valueOf(id));
		session.setAttribute("document", document);
		return "document/showUpdateDocument";
	}
	
	
	@RequestMapping(value = "/document/delDocument", method = { RequestMethod.POST, RequestMethod.GET })
	public String delDocument(HttpServletRequest request, HttpSession session) {
		String[] select = request.getParameterValues("check");
		for (int i = 0; i < select.length; i++) {
			if (select[i].compareTo("on") != 0)
				documentService.deleteByPrimaryKey(Integer.valueOf(select[i]));
		}
		List<Document> documents = documentService.selectAllDocuments();
		session.setAttribute("datas", documents);
		return "document/document";
	}
	
	@RequestMapping(value = "/document/adddDocument", method = { RequestMethod.POST, RequestMethod.GET })
	public String adddDocument(HttpServletRequest request, HttpSession session) {
		String title = request.getParameter("title");
		String remark = request.getParameter("remark");
		String filename = request.getParameter("filename");
		User user=(User)session.getAttribute("loginedUser");
		Document document=new Document(title, filename, remark, new Date(), user.getId());
		documentService.insert(document);
		
		List<Document> documents = documentService.selectAllDocuments();
		session.setAttribute("datas", documents);
		return "document/document";
	}
}
