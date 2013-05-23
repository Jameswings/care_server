package com.cd.careserver.action.jsonp;

import com.cd.careserver.service.CustomerService;

public class CustomerAction extends JsonpAction {
	private static final long serialVersionUID = 6344288894215313965L;

	private CustomerService customerService;
	
	public String getCustomerList(){
		
		return writeJsonp();
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
