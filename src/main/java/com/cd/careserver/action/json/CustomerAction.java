package com.cd.careserver.action.json;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.cd.careserver.service.CustomerService;
import com.cd.careserver.vo.CustomerInfo;

public class CustomerAction extends JsonAction {
	private static final long serialVersionUID = 6344288894215313965L;

	private CustomerService customerService;
	
//	private List<CustomerInfo> customerList = new ArrayList<CustomerInfo>();
	
	private CustomerInfo customer;
	
	public String getCustomerInfo(){
		if (getSessionDoctor() != null){
			reply.setValue(customerService.getCustomersByDocId(getSessionDoctor().getId()));
		}
		
		return JSON;
	}
	
	public String saveCustomerMonitored(){
		boolean result = customerService.setCustomerMonitored(customer);
		if (!result){
			setFailure("Error");
		}
		return JSON;
	}
	
	public CustomerInfo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
