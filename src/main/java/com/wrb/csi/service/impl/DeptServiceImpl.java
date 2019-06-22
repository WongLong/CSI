package com.wrb.csi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.DeptDao;
import com.wrb.csi.model.Dept;
import com.wrb.csi.service.DeptService;
import com.wrb.csi.service.RedisService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private RedisService redisService;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		String key = "dept_" + id;
		if (redisService.hasKey(key)) {
			redisService.delete(key);
		}
		return deptDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Dept record) {
		return deptDao.insert(record);
	}

	@Override
	public int insertSelective(Dept record) {
		return deptDao.insertSelective(record);
	}

	@Override
	public Dept selectByPrimaryKey(Integer id) {
		String key = "dept_" + id;
		if (redisService.hasKey(key)) {
			Dept dept = (Dept) redisService.get(key);
			return dept;
		}

		Dept dept = deptDao.selectByPrimaryKey(id);
		redisService.set(key, dept);
		return dept;
	}

	@Override
	public int updateByPrimaryKeySelective(Dept record) {
		String key = "dept_" + record.getId();
		redisService.set(key, record);
		return deptDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dept record) {
		String key = "dept_" + record.getId();
		redisService.set(key, record);
		return deptDao.updateByPrimaryKey(record);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> selecteAllDepts() {
		String key = "depts";
		if (redisService.hasKey(key)) {
			List<Dept> depts = (List<Dept>) redisService.get(key);
			return depts;
		}

		List<Dept> depts = deptDao.selecteAllDepts();
		redisService.set(key, depts);
		return depts;
	}
}
