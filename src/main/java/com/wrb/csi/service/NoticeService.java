package com.wrb.csi.service;

import java.util.List;

import com.wrb.csi.model.Notice;

public interface NoticeService {
    int deleteByPrimaryKey(Integer id);
    int insert(Notice record);
    int insertSelective(Notice record);
    Notice selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Notice record);
    int updateByPrimaryKey(Notice record);
    List<Notice> selectAllNotices();
}
