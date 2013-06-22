package com.cd.careserver.action.json;

import com.cd.careserver.dict.DiagnosisStatus;
import com.cd.careserver.po.Diagnosis;
import com.cd.careserver.service.DiagnosisService;

public class DiagnosisAction extends JsonAction {
	private static final long serialVersionUID = 6635505965367828155L;

	private DiagnosisService diagnosisService;

	private String ecgId;
	private String doctorId;
	private String customerId;
	private String message;

	public String save() {
		Diagnosis diag = new Diagnosis();
		diag.setEcgId(ecgId);
		diag.setCustomerId(customerId);
		diag.setDoctorId(getSessionDoctor().getId());
		diag.setMessage(message);
		diag.setStatus(DiagnosisStatus.INIT.getValue());
		if (diagnosisService.saveDiagnosis(diag) != null){			
			setSuccess("诊断信息保存成功，等待用户反馈");
		}else{
			setFailure("Unknown error!");
		}
		return JSON;
	}

	public String retrieveByEcg() {
		reply.setValue(diagnosisService.getDiagnosis(ecgId, getSessionDoctor()
				.getId()));
		return JSON;
	}

	public String getEcgId() {
		return ecgId;
	}

	public void setEcgId(String ecgId) {
		this.ecgId = ecgId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDiagnosisService(DiagnosisService diagnosisService) {
		this.diagnosisService = diagnosisService;
	}
}
