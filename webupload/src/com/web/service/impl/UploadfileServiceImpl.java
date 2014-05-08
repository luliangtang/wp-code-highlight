package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.dao.IUploadfileDao;
import com.web.service.IUploadfileService;
import com.web.vo.Uploadfile;

@Service(value="iUploadfileService")
public class UploadfileServiceImpl implements IUploadfileService {
	
	@Resource(name="iUploadfileDao")
	private IUploadfileDao iUploadfileDao;
	public void addUploadfile(Uploadfile uf) {
		// TODO Auto-generated method stub
		iUploadfileDao.save(uf);
		
	}

}
