package com.cd.careserver.service;

import com.cd.careserver.dao.PendingRequestDao;
import com.cd.careserver.po.PendingRequest;

public class PendingRequestServiceImpl implements PendingRequestService {
	
	private PendingRequestDao pendingRequestDao;

	public void setPendingRequestDao(PendingRequestDao pendingRequestDao) {
		this.pendingRequestDao = pendingRequestDao;
	}

	public String addPendingRequest(PendingRequest pr){
		return pendingRequestDao.insert(pr);
	}
}
