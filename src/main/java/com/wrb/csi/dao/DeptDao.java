package com.wrb.csi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wrb.csi.model.Dept;

@Mapper
public interface DeptDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept_inf
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept_inf
     *
     * @mbggenerated
     */
    int insert(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept_inf
     *
     * @mbggenerated
     */
    int insertSelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept_inf
     *
     * @mbggenerated
     */
    Dept selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept_inf
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept_inf
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Dept record);
    List<Dept> selectAllDepts();
}