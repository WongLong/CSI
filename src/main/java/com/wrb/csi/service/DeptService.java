package com.wrb.csi.service;

import java.util.List;

import com.wrb.csi.model.Dept;
import com.wrb.csi.model.User;

public interface DeptService {
	int deleteByPrimaryKey(Integer id);
	int insert(Dept record);
	int insertSelective(Dept record);
	Dept selectByPrimaryKey(Integer id);
	int updateByPrimaryKeySelective(Dept record);
	int updateByPrimaryKey(Dept record);
	List<Dept> selectAllDepts();
}
