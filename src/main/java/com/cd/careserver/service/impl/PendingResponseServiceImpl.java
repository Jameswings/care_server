package com.cd.careserver.service.impl;

import com.cd.careserver.dao.PendingResponseDao;
import com.cd.careserver.po.PendingResponse;
import com.cd.careserver.service.PendingResponseService;

public class PendingResponseServiceImpl implements PendingResponseService {

	private PendingResponseDao responseDao;
	
	@Override
	public String addResponse(PendingResponse resp) {
		return responseDao.insert(resp);
	}

	public void setPendingResponseDao(PendingResponseDao responseDao) {
		this.responseDao = responseDao;
	}
}
