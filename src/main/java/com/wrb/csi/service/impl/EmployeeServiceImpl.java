package com.wrb.csi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.DeptDao;
import com.wrb.csi.dao.EmployeeDao;
import com.wrb.csi.dao.JobDao;
import com.wrb.csi.model.Employee;
import com.wrb.csi.service.EmployeeService;
import com.wrb.csi.service.RedisService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private JobDao jobDao;
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
		for(int i=0;i<employees.size();i++) {
			employees.get(i).setDeptname(deptDao.selectByPrimaryKey(employees.get(i).getDeptid()).getName());
			employees.get(i).setJobname(jobDao.selectByPrimaryKey(employees.get(i).getJobid()).getName());
		}
		redisService.set(key, employees);
		return employees;
	}

	@Override
	public List<Employee> searchEmployees(String job_id, String name, String cardId, String sex, String phone,
			String dept_id) {
		List<Employee> employees=this.selectAllEmployees();
		List<Employee> result=new ArrayList<Employee>();
		
		if(job_id.compareTo("0")!=0) {				
			for(int i=0;i<employees.size();i++) {
				if(employees.get(i).getJobid().compareTo(Integer.valueOf(job_id))==0) {
					result.add(employees.get(i));
				}
			}
		}
		else {
			result.addAll(employees);
		}
		employees.clear();
		
		if(name.compareTo("")!=0 && name!=null) {
			for(int i=0;i<result.size();i++) {
				if(result.get(i).getName().compareTo(name)==0) {
					employees.add(result.get(i));
				}
			}
		}
		else {
			employees.addAll(result);
		}
		result.clear();
		
		
		if(sex.compareTo("0")!=0) {				
			for(int i=0;i<employees.size();i++) {
				if(employees.get(i).getSex().compareTo(Integer.valueOf(sex))==0) {
					result.add(employees.get(i));
				}
			}
		}
		else {
			result.addAll(employees);
		}
		employees.clear();
		
		if(cardId.compareTo("")!=0 && cardId!=null) {
			for(int i=0;i<result.size();i++) {
				if(result.get(i).getCardid().compareTo(cardId)==0) {
					employees.add(result.get(i));
				}
			}
		}
		else {
			employees.addAll(result);
		}
		result.clear();
		
		
		if(dept_id.compareTo("0")!=0) {				
			for(int i=0;i<employees.size();i++) {
				if(employees.get(i).getDeptid().compareTo(Integer.valueOf(dept_id))==0) {
					result.add(employees.get(i));
				}
			}
		}
		else {
			result.addAll(employees);
		}
		employees.clear();
		
		if(phone.compareTo("")!=0 && phone!=null) {
			for(int i=0;i<result.size();i++) {
				if(result.get(i).getPhone().compareTo(phone)==0) {
					employees.add(result.get(i));
				}
			}
		}
		else {
			employees.addAll(result);
		}
		result.clear();
		
		return employees;
	}
}
