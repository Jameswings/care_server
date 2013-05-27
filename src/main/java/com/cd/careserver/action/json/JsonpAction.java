package com.cd.careserver.action.json;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.james.common.utils.ajax.Reply;

import com.cd.careserver.action.BaseAction;


@Results({ 
	@Result(name = "jsonp", type = "json")
})
public class JsonpAction extends BaseAction {

	private static final long serialVersionUID = 8709805605273167406L;
	
	public static final String REPLY_KEY = "reply_key_in_session";

	private String callback;

	@Override
	public String invalidUser() {
		setFailure("Invalid User!");
		return writeJsonp();
	}
	
	public String writeJsonp(){

		HttpServletResponse response = ServletActionContext.getResponse();
		String content = JSONObject.fromObject(reply).toString();
		String cb = reply.getCallback();
	    if (cb != null){
	    	content = cb + "(" + content + ");";
	    	response.setContentType("text/javascript");
	    }else{
	    	response.setContentType("text/json");
	    }
	    response.setHeader("Content-Length", String.valueOf(content.length()));
		try {
			Writer out = response.getWriter();
			out.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JSONP;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		reply.setCallback(callback);
		this.callback = callback;
	}
}
