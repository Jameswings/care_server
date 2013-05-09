package com.cd.careserver.actions;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "json", type = "json", params = { "root", "msg" }) })
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 8256468859982232293L;

	private String msg = "It Works!!";
	
	public String execute(){
		return "json";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
