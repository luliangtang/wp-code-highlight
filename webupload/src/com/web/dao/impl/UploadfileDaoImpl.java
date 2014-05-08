package com.web.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.IUploadfileDao;
import com.web.vo.Uploadfile;
@Repository(value="iUploadfileDao")
@Scope("singleton")
@Transactional(rollbackFor = Throwable.class, value = "transactionManager")
public class UploadfileDaoImpl extends BaseDaoImpl<Uploadfile> implements IUploadfileDao{

	@Override
	public Class<Uploadfile> getDomainClass() {
		// TODO Auto-generated method stub
		return Uploadfile.class;
	}

	public void add(Uploadfile uobj) {
		// TODO Auto-generated method stub
	System.out.println("xuai");	
	}

}
