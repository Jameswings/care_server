package com.cd.careserver.actions.api;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.james.common.utils.ajax.Reply;

import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "json", type = "json", params = { "root", "reply" }) })
public class JsonAction extends ActionSupport {

	private static final long serialVersionUID = 8256468859982232293L;

	public static final String JSON = "json";
	public static final String JSONP = "jsonp";

	protected Reply reply = new Reply();

	public String execute() {
		reply.setMsg("It Works!!");
		return JSON;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

}
