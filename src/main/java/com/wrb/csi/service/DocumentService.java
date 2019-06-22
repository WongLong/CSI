package com.wrb.csi.service;

import java.util.List;

import com.wrb.csi.model.Document;

public interface DocumentService {
	int deleteByPrimaryKey(Integer id);
	int insert(Document record);
	int insertSelective(Document record);
	Document selectByPrimaryKey(Integer id);
	int updateByPrimaryKeySelective(Document record);
	int updateByPrimaryKey(Document record);
	List<Document> selectAllDocuments();
}
