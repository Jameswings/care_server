package com.cd.careserver.dao;

import java.util.List;

import com.cd.careserver.po.PendingResponse;

public interface PendingResponseDao {

	List<PendingResponse> findAll();

	String insert(PendingResponse pendingResponse);

	String delete(String pendingResponseId);

	PendingResponse findById(String pendingResponseId);

}
