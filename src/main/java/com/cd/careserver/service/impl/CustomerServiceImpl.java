package com.cd.careserver.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cd.careserver.dao.CustomerDao;
import com.cd.careserver.dao.DoctorCustomerDao;
import com.cd.careserver.po.Customer;
import com.cd.careserver.po.Doctor;
import com.cd.careserver.po.DoctorCustomer;
import com.cd.careserver.service.CustomerService;
import com.cd.careserver.vo.CustomerInfo;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	private DoctorCustomerDao doctorCustomerDao;
	
	public List<Customer> getAllCustomers(){
		return customerDao.findAll();
	}
	
	public List<CustomerInfo> getCustomersByDoc(Doctor doc){
		List<CustomerInfo> result = new ArrayList<CustomerInfo>();
		List<Customer> cList = getAllCustomers();
		List<DoctorCustomer> dcList = doctorCustomerDao.findByDoctorId(doc.getId());
		
		if (!cList.isEmpty()){
			Map<String, DoctorCustomer> cidMap = new HashMap<String, DoctorCustomer>();
			for (DoctorCustomer dc: dcList){
				cidMap.put(dc.getCustomerId(), dc);
			}
			
			CustomerInfo info;
			for (Customer c: cList){
				info = new CustomerInfo(c);
				
				if (cidMap.containsKey(c.getId())){
//					info.set
					info.collect(cidMap.get(c.getId()));
				}
				
				result.add(info);
			}
		}
		
		return result;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setDoctorCustomerDao(DoctorCustomerDao doctorCustomerDao) {
		this.doctorCustomerDao = doctorCustomerDao;
	}
}
