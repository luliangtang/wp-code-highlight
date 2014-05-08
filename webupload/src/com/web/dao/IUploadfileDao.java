package com.web.dao;

import com.web.vo.Uploadfile;

public interface IUploadfileDao extends BaseDao<Uploadfile>{
	/**
	 * ÐÂÔö
	 * @param uobj
	 */
    public void add(Uploadfile uobj);
}
