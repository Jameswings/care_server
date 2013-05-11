package com.cd.careserver.action.api;

import com.cd.careserver.po.PendingRequest;
import com.cd.careserver.service.PendingRequestService;

public class RequestAction extends JsonAction {

	private static final long serialVersionUID = -1240610887297048051L;
	
	private PendingRequestService pendingRequestService;
	public void setPendingRequestService(PendingRequestService pendingRequestService) {
		this.pendingRequestService = pendingRequestService;
	}

	private String cmd;
	private String fromId;
	private String toId;
	private String message;

	public String send(){
		PendingRequest pr = new PendingRequest();
		pr.setCmd(cmd);
		pr.setFromId(fromId);
		pr.setFromType(1);
		pr.setToId(toId);
		pr.setToType(0);
		pr.setMessage(message);
		
		String reId = pendingRequestService.addPendingRequest(pr);
		if (reId != null){
			setSuccess("Request received!");
		}else{
			
		}
//		pr.
		return JSON;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PendingRequestService getPendingRequestService() {
		return pendingRequestService;
	}
}
