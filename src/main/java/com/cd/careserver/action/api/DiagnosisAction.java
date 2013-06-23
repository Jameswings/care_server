package com.cd.careserver.action.api;

import com.cd.careserver.service.DiagnosisService;

public class DiagnosisAction extends APIAction {
	private static final long serialVersionUID = 8020550432860025080L;

	private DiagnosisService diagnosisService;
	
	private String diagnosisId;
	
	public String retrieve(){
		reply.setValue(diagnosisService.getDiagnosisById(diagnosisId));
		return JSON;
	}

	public String getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public void setDiagnosisService(DiagnosisService diagnosisService) {
		this.diagnosisService = diagnosisService;
	}
}
