package com.cd.careserver.action.json;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.james.common.utils.ajax.Reply;

import com.cd.careserver.action.BaseAction;


@Results({ @Result(name = "json", type = "json", params = { "root", "reply" }) })
public class JsonAction extends BaseAction {

	private static final long serialVersionUID = 8256468859982232293L;

	public static final String JSON = "json";
	
	@Override
	public String invalidUser() {
		this.setFailure("Invalid User!");
		return JSON;
	}

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
