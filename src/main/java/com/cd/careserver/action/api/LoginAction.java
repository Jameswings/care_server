package com.cd.careserver.action.api;

import org.apache.struts2.ServletActionContext;

import com.cd.careserver.action.json.JsonAction;
import com.cd.careserver.po.User;


public class LoginAction extends JsonAction {

	private static final long serialVersionUID = 5210373691075379789L;

	private String username;
	private String password;
	private int type;
	
	public String execute(){
		if ("demo".equals(username) && "demo".equals(password) && type == 1){
			User u = new User();
			u.setUsername(username);
			u.setType(type);
			u.setStatus(1);
			ServletActionContext.getRequest().getSession().setAttribute(User.SESSION_USER_KEY, u);
			reply.setMsg("login success");
			reply.setCode(1);
		}else{
			reply.setMsg("login falure");
			reply.setCode(0);
		}
		
		return JSON;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(int type) {
		this.type = type;
	}
}
