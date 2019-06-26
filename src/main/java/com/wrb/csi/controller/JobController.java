package com.wrb.csi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrb.csi.model.Job;
import com.wrb.csi.service.JobService;

@Controller
public class JobController {
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value = "/job/searchJob", method = { RequestMethod.POST, RequestMethod.GET })
	public String seacherJob(HttpServletRequest request, HttpSession session) {
		String jobrname = request.getParameter("jobname");
		List<Job> jobs = jobService.selectAllJobs();
		List<Job> result = new ArrayList<Job>();
		if (jobrname == null || jobrname.compareTo("") == 0) {
			session.setAttribute("datas", jobs);
		} else {
			for (int i = 0; i < jobs.size(); i++) {
				if (jobs.get(i).getName().compareTo(jobrname) == 0)
					result.add(jobs.get(i));
			}
			session.setAttribute("datas", result);
		}
		return "job/job";
	}
	
	
	@RequestMapping(value = "/job/AllJob", method = { RequestMethod.POST, RequestMethod.GET })
	public String AllEmployee(HttpServletRequest request, HttpSession session) {
		List<Job> Job = jobService.selectAllJobs();
		session.setAttribute("datas", Job);
		return "job/job";
	}

	@RequestMapping(value = "/job/addJob", method = { RequestMethod.POST, RequestMethod.GET })
	public String addJob(HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("name");
		String remark = request.getParameter("remark");
		Job job = new Job(name, remark);
		jobService.insert(job);
		List<Job> jobs = jobService.selectAllJobs();
		session.setAttribute("datas", jobs);
		return "job/job";
	}

	@RequestMapping(value = "/job/delJob", method = { RequestMethod.POST, RequestMethod.GET })
	public String delJob(HttpServletRequest request, HttpSession session) {
		String[] select = request.getParameterValues("checkbox");
		for (int i = 0; i < select.length; i++) {
			if (select[i].compareTo("on") != 0)
				jobService.deleteByPrimaryKey(Integer.valueOf(select[i]));
		}
		List<Job> jobs = jobService.selectAllJobs();
		session.setAttribute("datas", jobs);
		return "job/job";
	}
	
	@RequestMapping(value = "/job/transmitId", method = { RequestMethod.POST, RequestMethod.GET })
	public String transmitId(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		Job job=jobService.selectByPrimaryKey(Integer.valueOf(id));
		session.setAttribute("job", job);
		return "job/showUpdateJob";
	}
	
	@RequestMapping(value = "/job/changeJob", method = { RequestMethod.POST, RequestMethod.GET })
	public String changeJob(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String remark = request.getParameter("remark");
		Job job=new Job(name, remark);
		job.setId(Integer.valueOf(id));
		jobService.updateByPrimaryKey(job);
		List<Job> jobs = jobService.selectAllJobs();
		session.setAttribute("datas", jobs);
		return "job/job";
	}
}
