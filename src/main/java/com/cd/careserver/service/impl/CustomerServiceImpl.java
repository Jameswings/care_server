package com.cd.careserver.service.impl;

import com.cd.careserver.dao.CustomerDao;
import com.cd.careserver.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
