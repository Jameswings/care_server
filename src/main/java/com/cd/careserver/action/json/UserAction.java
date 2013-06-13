package com.cd.careserver.action.json;

import com.cd.careserver.dict.UserType;
import com.cd.careserver.service.CustomerService;
import com.cd.careserver.service.DoctorService;
import com.cd.careserver.service.UserService;
import com.cd.careserver.vo.UserInfo;

public class UserAction extends JsonAction {
	private static final long serialVersionUID = 7543372410066684842L;

	private UserInfo userInfo;
	
	private CustomerService customerService;
	private DoctorService doctorService;
	private UserService userService;
	
	public String addUser(){
		if (userInfo.getType() == UserType.CUSTOMER.getValue()){
			
		}else if (userInfo.getType() == UserType.DOCTOR.getValue()){
			
		}else{
			
		}
		return JSON;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
