package com.cd.careserver.service;

import java.util.List;

import com.cd.careserver.po.PendingResponse;

public interface PendingResponseService {

	String addResponse(PendingResponse resp);
	
	List<PendingResponse> getAllResponseByCustomerId(String customerId);
}
