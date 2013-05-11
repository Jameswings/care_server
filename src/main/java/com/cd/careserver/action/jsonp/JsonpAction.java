package com.cd.careserver.action.jsonp;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cd.careserver.action.BaseAction;

@Results({ @Result(name = "jsonp", type = "json", params = { "root", "reply.callback" }) })
public class JsonpAction extends BaseAction {

	private static final long serialVersionUID = 8709805605273167406L;

	public String jsonp(){
		reply.setCallback("function abc(){alert(1);}");
		return JSONP;
	}
}
