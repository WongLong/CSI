package com.wrb.csi.service.impl;

import java.util.ArrayList;
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
		redisService.delete(key);
		redisService.delete("depts");
		return deptDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Dept record) {
		redisService.delete("depts");
		return deptDao.insert(record);
	}

	@Override
	public int insertSelective(Dept record) {
		redisService.delete("depts");
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
		redisService.delete("depts");
		return deptDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dept record) {
		String key = "dept_" + record.getId();
		redisService.set(key, record);
		redisService.delete("depts");
		return deptDao.updateByPrimaryKey(record);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> selectAllDepts() {
		String key = "depts";
		if (redisService.hasKey(key)) {
			List<Dept> depts = (List<Dept>) redisService.get(key);
			return depts;
		}

		List<Dept> depts = deptDao.selectAllDepts();
		redisService.set(key, depts);
		return depts;
	}

	@Override
	public List<Dept> searchDept(String name) {
		List<Dept> depts = this.selectAllDepts();
		List<Dept> dept = new ArrayList<Dept>();
		if (name == "" || name == null) {
			return depts;
		} else {
			for (int i = 0; i < depts.size(); i++) {
				if (depts.get(i).getName().equals(name)) {
					dept.add(depts.get(i));
				}
			}
			return dept;
		}
	}

}
