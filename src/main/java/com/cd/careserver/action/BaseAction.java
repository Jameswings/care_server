package com.cd.careserver.action;

import org.james.common.utils.ajax.Reply;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 8256468859982232293L;

	public static final String JSON = "json";
	public static final String JSONP = "jsonp";

	protected Reply reply = new Reply();

	public String execute() {
		reply.setMsg("It Works!!");
		return JSON;
	}
	
	public String invalidUser(){
		reply.setMsg("Invalid user!");
		reply.setCode(0);
		return JSON;
	}
	
	protected void setSuccess(){
		this.setSuccess("");
	}
	
	protected void setSuccess(String msg){
		reply.setCode(1);
		reply.setSuccess(true);
		reply.setMsg(msg);
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

}