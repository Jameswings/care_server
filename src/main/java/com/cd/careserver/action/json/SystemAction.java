package com.cd.careserver.action.json;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;

import com.cd.careserver.dict.UserType;
import com.cd.careserver.po.Customer;
import com.cd.careserver.po.Doctor;
import com.cd.careserver.po.User;
import com.cd.careserver.service.CustomerService;
import com.cd.careserver.service.DoctorService;
import com.cd.careserver.service.SystemService;

@InterceptorRefs({ @InterceptorRef("basicStack") })
public final class SystemAction extends JsonAction {

	private static final long serialVersionUID = -4051414049841931428L;
	
	private SystemService systemService;
	private CustomerService customerService;
	private DoctorService doctorService;

	public String ping(){
		setSuccess();
		return JSON;
	}
	
	private String userName;
	private String password;
	private int type;
	
	public String login(){
		User user = systemService.login(1, userName, password);
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
			
			setSuccess("login success!");
		}else{
			setFailure("Invalid username or password!");
		}
		return JSON;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
