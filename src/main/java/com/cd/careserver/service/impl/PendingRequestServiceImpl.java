package com.cd.careserver.service.impl;

import com.cd.careserver.dao.PendingRequestDao;
import com.cd.careserver.po.PendingRequest;
import com.cd.careserver.service.PendingRequestService;

public class PendingRequestServiceImpl implements PendingRequestService {
	
	private PendingRequestDao pendingRequestDao;

	public void setPendingRequestDao(PendingRequestDao pendingRequestDao) {
		this.pendingRequestDao = pendingRequestDao;
	}

	public String addPendingRequest(PendingRequest pr){
		return pendingRequestDao.insert(pr);
	}
}
