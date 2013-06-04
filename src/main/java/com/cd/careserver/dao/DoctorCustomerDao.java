package com.cd.careserver.dao;

import java.util.List;

import com.cd.careserver.po.DoctorCustomer;

public interface DoctorCustomerDao {

	List<DoctorCustomer> findByDoctorId(String docId);

	List<DoctorCustomer> findByCustomerId(String cusId);

	int insert(DoctorCustomer dc);
	
	int delete(DoctorCustomer dc);

	DoctorCustomer findByDocIdAndCustomerId(String docId, String cusId);
}
