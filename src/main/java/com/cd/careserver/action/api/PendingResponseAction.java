package com.cd.careserver.action.api;

import com.cd.careserver.service.PendingResponseService;

public class PendingResponseAction extends APIAction {
	private static final long serialVersionUID = -2643694161539576679L;

	private PendingResponseService responseService;

	public String retrieveAllResponse() {
		reply.setValue(responseService
				.getAllResponseByCustomerId(getSessionCustomer().getId()));
		return JSON;
	}

	public void setPendingResponseService(PendingResponseService responseService) {
		this.responseService = responseService;
	}
}
