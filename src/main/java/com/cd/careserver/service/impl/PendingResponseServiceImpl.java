package com.cd.careserver.service.impl;

import java.util.List;

import com.cd.careserver.dao.PendingResponseDao;
import com.cd.careserver.po.PendingResponse;
import com.cd.careserver.service.PendingResponseService;

public class PendingResponseServiceImpl implements PendingResponseService {

	private PendingResponseDao responseDao;
	
	@Override
	public String addResponse(PendingResponse resp) {
		return responseDao.insert(resp);
	}
	
	@Override
	public List<PendingResponse> getAllResponseByCustomerId(String customerId) {
		return responseDao.findByCustomerId(customerId);
	}

	public void setPendingResponseDao(PendingResponseDao responseDao) {
		this.responseDao = responseDao;
	}
}
