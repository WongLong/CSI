package com.wrb.csi.service;

import java.util.List;

import com.wrb.csi.model.Employee;

public interface EmployeeService {
	int deleteByPrimaryKey(Integer id);
	int insert(Employee record);
	int insertSelective(Employee record);
    Employee selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Employee record);
    int updateByPrimaryKey(Employee record);
    List<Employee> selectAllEmployees();
    List<Employee> searchEmployees(String job_id,String name,String cardId,String sex,String phone,String dept_id);
}
