package com.cd.careserver.action.api;

import java.util.HashMap;
import java.util.Map;

import com.cd.careserver.config.Config;

public class EcgAction extends JsonAction {

	private static final long serialVersionUID = 7689517809161378138L;

	public String getFtpInfo(){
		
		Map<String, String> ftpInfo = new HashMap<String, String>();
		
		ftpInfo.put("url", Config.getFtpUrl());
		ftpInfo.put("username", Config.getFtpUsername());
		ftpInfo.put("password", Config.getFtpPassword());
		
		setSuccess();
		reply.setValue(ftpInfo);
		return JSON;
	}
}
