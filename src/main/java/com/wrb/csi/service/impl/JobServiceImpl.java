package com.wrb.csi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.JobDao;
import com.wrb.csi.model.Job;
import com.wrb.csi.service.JobService;
import com.wrb.csi.service.RedisService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobDao jobDao;
	@Autowired
	private RedisService redisService;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		String key = "job_" + id;
		redisService.delete(key);
		redisService.delete("jobs");
		return jobDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Job record) {
		redisService.delete("jobs");
		return jobDao.insert(record);
	}

	@Override
	public int insertSelective(Job record) {
		redisService.delete("jobs");
		return jobDao.insertSelective(record);
	}

	@Override
	public Job selectByPrimaryKey(Integer id) {
		String key = "job_" + id;
		if (redisService.hasKey(key)) {
			Job job = (Job) redisService.get(key);
			return job;
		}

		Job job = jobDao.selectByPrimaryKey(id);
		redisService.set(key, job);
		return job;
	}

	@Override
	public int updateByPrimaryKeySelective(Job record) {
		String key = "job_" + record.getId();
		redisService.set(key, record);
		redisService.delete("jobs");
		return jobDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Job record) {
		String key = "job_" + record.getId();
		redisService.set(key, record);
		redisService.delete("jobs");
		return jobDao.updateByPrimaryKey(record);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> selectAllJobs() {
		String key = "jobs";
		if (redisService.hasKey(key)) {
			List<Job> jobs = (List<Job>) redisService.get(key);
			return jobs;
		}

		List<Job> jobs = jobDao.selectAllJobs();
		redisService.set(key, jobs);
		return jobs;
	}

}
