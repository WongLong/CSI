package com.wrb.csi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wrb.csi.model.Employee;

@Mapper
public interface EmployeeDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Employee record);
    List<Employee> selectAllEmployees();
}