package com.wrb.csi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.EmployeeDao;
import com.wrb.csi.model.Employee;
import com.wrb.csi.service.EmployeeService;
import com.wrb.csi.service.RedisService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private RedisService redisService;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		String key = "employee_" + id;
		redisService.delete(key);
		redisService.delete("employees");
		return employeeDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Employee record) {
		redisService.delete("employees");
		return employeeDao.insert(record);
	}

	@Override
	public int insertSelective(Employee record) {
		redisService.delete("employees");
		return employeeDao.insertSelective(record);
	}

	@Override
	public Employee selectByPrimaryKey(Integer id) {
		String key = "employee_" + id;
		if (redisService.hasKey(key)) {
			Employee employee = (Employee) redisService.get(key);
			return employee;
		}
		Employee employee = employeeDao.selectByPrimaryKey(id);
		redisService.set(key, employee);
		return employee;
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		String key = "employee_" + record.getId();
		redisService.set(key, record);
		redisService.delete("employees");
		return employeeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		String key = "employee_" + record.getId();
		redisService.set(key, record);
		redisService.delete("employees");
		return employeeDao.updateByPrimaryKey(record);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> selectAllEmployees() {
		String key = "employees";
		if (redisService.hasKey(key)) {
			List<Employee> employees = (List<Employee>) redisService.get(key);
			return employees;
		}
		List<Employee> employees = employeeDao.selectAllEmployees();
		redisService.set(key, employees);
		return employees;
	}
}
