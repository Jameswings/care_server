package com.cd.careserver.action.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.cd.careserver.service.CustomerService;
import com.cd.careserver.vo.CustomerInfo;

public class CustomerAction extends JsonAction {
	private static final long serialVersionUID = 6344288894215313965L;

	private CustomerService customerService;
	
	private List<CustomerInfo> customerList = new ArrayList<CustomerInfo>();
	
	private List<String> testList = new ArrayList<String>();
	
	public String getCustomerInfo(){
		if (getSessionDoctor() != null){
			reply.setValue(customerService.getCustomersByDoc(getSessionDoctor()));
		}
		
		return JSON;
	}
	
	public String saveCustomerMonitored(){
		System.out.println(ServletActionContext.getRequest().getParameter("customerList"));
		System.out.println(customerList);
		System.out.println(ServletActionContext.getRequest().getParameter("testList"));
		System.out.println(testList);
		return JSON;
	}

	public void setCustomerList(List<CustomerInfo> customerList) {
		this.customerList = customerList;
	}
	
	public Object getModel(){
		return customerList;
	}

	public List<CustomerInfo> getCustomerList() {
		return customerList;
	}

	public List<String> getTestList() {
		return testList;
	}

	public void setTestList(List<String> testList) {
		this.testList = testList;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
