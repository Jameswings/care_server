package com.cd.careserver.action.api;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.james.common.utils.ajax.Reply;

import com.cd.careserver.action.BaseAction;
import com.cd.careserver.dict.UserType;
import com.cd.careserver.po.Customer;
import com.cd.careserver.po.Doctor;
import com.cd.careserver.po.User;
import com.cd.careserver.service.CustomerService;
import com.cd.careserver.service.DoctorService;
import com.cd.careserver.service.SystemService;


@Results({ @Result(name = "json", type = "json", params = { "root", "reply" }) })
public class APIAction extends BaseAction {
	private static final long serialVersionUID = 8256468859982232293L;

	public static final String JSON = "json";
	
	private SystemService systemService;
	private CustomerService customerService;
	private DoctorService doctorService;
	
	private int type;
	private String username;
	private String password;
	
	@Override
	public String invalidUser() {
		this.setFailure("Invalid User!");
		return JSON;
	}

	public String execute() {
		reply.setMsg("It Works!!");
		return JSON;
	}
	
	public boolean testUser(){
		User user = systemService.login(type, username, password);
		if (user != null){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(User.SESSION_USER_KEY, user);
			
			UserType t = UserType.valueOf(user.getType());
			switch(t){
			case DOCTOR:
				session.setAttribute(Doctor.SESSION_KEY, doctorService.getDoctorByUserId(user.getId()));
				break;
			case CUSTOMER:
				
				session.setAttribute(Customer.SESSION_KEY, customerService.getCustomerByUserId(user.getId()));
				break;
			default:
				
				break;	
			}
		}
		return user != null;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
}
