package com.cd.careserver.action.api;

import com.cd.careserver.service.DiagnosisService;

public class DiagnosisAction extends APIAction {
	private static final long serialVersionUID = 8020550432860025080L;

	private DiagnosisService diagnosisService;
	
	
	private String ecgId;
	
	public String retrieve(){
		return JSON;
	}

	public String getEcgId() {
		return ecgId;
	}

	public void setEcgId(String ecgId) {
		this.ecgId = ecgId;
	}

	public void setDiagnosisService(DiagnosisService diagnosisService) {
		this.diagnosisService = diagnosisService;
	}
}
