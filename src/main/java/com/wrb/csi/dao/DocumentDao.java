package com.wrb.csi.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wrb.csi.model.Document;

@Mapper
public interface DocumentDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_inf
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_inf
     *
     * @mbggenerated
     */
    int insert(Document record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_inf
     *
     * @mbggenerated
     */
    int insertSelective(Document record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_inf
     *
     * @mbggenerated
     */
    Document selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_inf
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Document record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_inf
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Document record);
}