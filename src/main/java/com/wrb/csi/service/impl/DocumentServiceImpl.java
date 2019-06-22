package com.wrb.csi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrb.csi.dao.DocumentDao;
import com.wrb.csi.model.Document;
import com.wrb.csi.service.DocumentService;
import com.wrb.csi.service.RedisService;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private DocumentDao documentDao;
	@Autowired
	private RedisService redisService;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		String key = "document_" + id;
		if (redisService.hasKey(key)) {
			redisService.delete(key);
		}
		return documentDao.deleteByPrimaryKey(id);
	}
	@Override
	public int insert(Document record) {
		return documentDao.insert(record);
	}
	@Override
	public int insertSelective(Document record) {
		return documentDao.insert(record);
	}
	@Override
	public Document selectByPrimaryKey(Integer id) {
		String key = "document_" + id;
		if (redisService.hasKey(key)) {
			Document document = (Document) redisService.get(key);
			return document;
		}
		
		Document document = documentDao.selectByPrimaryKey(id);
		redisService.set(key, document);
		return document;
	}
	@Override
	public int updateByPrimaryKeySelective(Document record) {
		String key = "document_" + record.getId();
		redisService.set(key, record);
		return documentDao.updateByPrimaryKeySelective(record);
	}
	@Override
	public int updateByPrimaryKey(Document record) {
		String key = "document_" + record.getId();
		redisService.set(key, record);
		return documentDao.updateByPrimaryKey(record);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Document> selectAllDocuments() {
		String key = "documents";
		if (redisService.hasKey(key)) {
			List<Document> documents = (List<Document>) redisService.get(key);
			return documents;
		}
		
		List<Document> documents = documentDao.selectAllDocuments();
		redisService.set(key, documents);
		return documents;
	}
}
