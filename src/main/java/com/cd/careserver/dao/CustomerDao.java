package com.cd.careserver.dao;

import java.util.List;

import com.cd.careserver.po.Customer;

public interface CustomerDao {

	String update(Customer customer);

	Customer findById(String customerId);

	String delete(String customerId);

	String insert(Customer customer);

	List<Customer> findAll();

	Customer findByUserId(String userId);
}
