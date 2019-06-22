package com.wrb.csi.service;

import java.util.List;

import com.wrb.csi.model.Job;

public interface JobService {
	int deleteByPrimaryKey(Integer id);
    int insert(Job record);
    int insertSelective(Job record);
    Job selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Job record);
    int updateByPrimaryKey(Job record);
    List<Job> selectAllJobs();
}
