package com.cd.careserver.action.jsonp;

import org.apache.struts2.ServletActionContext;

import com.cd.careserver.po.User;
import com.cd.careserver.service.SystemService;

public class SystemAction extends JsonpAction {

	private static final long serialVersionUID = -4051414049841931428L;
	
	private SystemService systemService;

	public String ping(){
		setSuccess();
		return writeJsonp();
	}
	
	private String userName;
	private String password;
	private int type;
	
	public String login(){
		User user = systemService.login(userName, password);
		if (user != null){
			ServletActionContext.getRequest().getSession().setAttribute(User.SESSION_USER_KEY, user);
			setSuccess("login success!");
		}else{
			setFailure("Invalid username or password!");
		}
		return writeJsonp();
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
}
