package com.cd.careserver.dao;

import java.util.List;

import com.cd.careserver.po.PendingRequest;

public interface PendingRequestDao {

	PendingRequest findById(String pendingRequestId);

	String update(PendingRequest pendingRequest);

	String delete(String pendingRequestId);

	String insert(PendingRequest pendingRequest);

	List<PendingRequest> findAll();
}
