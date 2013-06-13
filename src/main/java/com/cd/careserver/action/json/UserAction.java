package com.cd.careserver.action.json;

import com.cd.careserver.dict.CustomerType;
import com.cd.careserver.dict.UserStatus;
import com.cd.careserver.dict.UserType;
import com.cd.careserver.po.Customer;
import com.cd.careserver.po.Doctor;
import com.cd.careserver.po.User;
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
		User user = new User();
		user.setUsername(userInfo.getUsername());
		user.setPassword("123456");
		user.setType(userInfo.getType());
		user.setStatus(UserStatus.INIT.getValue());
		
		String userId = userService.addUser(user);
		if (userId != null){
			if (userInfo.getType() == UserType.CUSTOMER.getValue()){
				Customer c = new Customer();
				c.setUserId(userId);
				c.setCellPhone(userInfo.getCellPhone());
				c.setAge(userInfo.getAge());
				c.setIden(userInfo.getIden());
				c.setName(userInfo.getName());
				c.setNickName(userInfo.getNickName());
				c.setSex(userInfo.getSex());
				c.setType(CustomerType.NORMAL.getValue());
				String cid = customerService.addCustomer(c);
				if (cid == null){
					setFailure("Add user failue");
					return JSON;
				}
			}else if (userInfo.getType() == UserType.DOCTOR.getValue()){
				Doctor d = new Doctor();
				d.setUserId(userId);
				d.setCellPhone(userInfo.getCellPhone());
				d.setAge(userInfo.getAge());
				d.setIden(userInfo.getIden());
				d.setName(userInfo.getName());
				d.setNickName(userInfo.getNickName());
				d.setSex(userInfo.getSex());
				d.setAge(userInfo.getAge());
				String did = doctorService.addDoctor(d);
				if (did == null){
					setFailure("Add user failue");
					return JSON;
				}
			}
		}else{
			setFailure("Add user failue");
			return JSON;
		}
		setSuccess("User has been added!");
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
