package com.cd.careserver.action.jsonp;

public class SystemAction extends JsonpAction {

	private static final long serialVersionUID = -4051414049841931428L;

	public String ping(){
		setSuccess();
		return writeJsonp();
	}
	
	private String userName;
	private String password;
	private int type;
	
	public String login(){
		System.out.println(userName);
		System.out.println(password);
		System.out.println(type);
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
}
