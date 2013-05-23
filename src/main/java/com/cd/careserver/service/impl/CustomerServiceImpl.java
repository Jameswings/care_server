package com.cd.careserver.service.impl;

import java.util.List;

import com.cd.careserver.dao.CustomerDao;
import com.cd.careserver.po.Customer;
import com.cd.careserver.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	public List<Customer> getAllCustomers(){
		return customerDao.findAll();
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
