package com.cd.careserver.service;

import java.util.List;

import com.cd.careserver.po.Customer;
import com.cd.careserver.po.Doctor;
import com.cd.careserver.vo.CustomerInfo;

public interface CustomerService {

	List<Customer> getAllCustomers();

	List<CustomerInfo> getCustomersByDocId(String docId);

	boolean setCustomerMonitored(CustomerInfo ci);

	String addCustomer(Customer customer);

}
