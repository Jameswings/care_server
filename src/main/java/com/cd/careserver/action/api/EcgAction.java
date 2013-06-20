package com.cd.careserver.action.api;

import java.util.HashMap;
import java.util.Map;

import com.cd.careserver.config.Config;
import com.cd.careserver.po.EcgData;
import com.cd.careserver.service.EcgService;

public class EcgAction extends APIAction {

	private static final long serialVersionUID = 7689517809161378138L;
	
	private EcgService ecgService;
	
	private String fileLocation;

	public String getFtpInfo(){
		
		Map<String, String> ftpInfo = new HashMap<String, String>();
		
		ftpInfo.put("url", Config.getFtpUrl());
		ftpInfo.put("username", Config.getFtpUsername());
		ftpInfo.put("password", Config.getFtpPassword());
		
		setSuccess();
		reply.setValue(ftpInfo);
		return JSON;
	}
	
	
	public String newEcgData(){
		if (getSessionCustomer() != null){
			EcgData ecg = new EcgData();
			ecg.setCustomerId(getSessionCustomer().getId());
			ecg.setFileLocation(fileLocation);
			String id = ecgService.addEcg(ecg);
			if (id == null){
				setFailure("added ecg failure");
			}else{
				Map<String, String> apiReply = new HashMap<String, String>();
				apiReply.put("ecgId", id);
				reply.setValue(apiReply);
			}
		}else{
			setFailure("invalid users");
		}
		return JSON;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}


	public void setEcgService(EcgService ecgService) {
		this.ecgService = ecgService;
	}
}
