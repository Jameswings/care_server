package com.cd.careserver.service.impl;

import com.cd.careserver.dao.DiagnosisDao;
import com.cd.careserver.dict.ResponseType;
import com.cd.careserver.dict.UserType;
import com.cd.careserver.po.Diagnosis;
import com.cd.careserver.po.PendingResponse;
import com.cd.careserver.service.DiagnosisService;
import com.cd.careserver.service.PendingResponseService;

public class DiagnosisServiceImpl implements DiagnosisService {

	private DiagnosisDao diagnosisDao;
	private PendingResponseService responseService;
	
	public Diagnosis getDiagnosis(String ecgId, String docId){
		return diagnosisDao.findByEcgIdAndDoctorId(ecgId, docId);
	}
	
	public String saveDiagnosis(Diagnosis diagnosis){
		String id = diagnosisDao.insert(diagnosis);
		if (id != null){
			PendingResponse response = new PendingResponse();
			response.setType(ResponseType.DIAGNOSIS.getValue());
			response.setFromId(diagnosis.getDoctorId());
			response.setFromType(UserType.DOCTOR.getValue());
			response.setToId(diagnosis.getCustomerId());
			response.setToType(UserType.CUSTOMER.getValue());
			response.setMessage("empty");
			response.setCmd("empty");
			responseService.addResponse(response);
		}
		return id;
	}

	public void setDiagnosisDao(DiagnosisDao diagnosisDao) {
		this.diagnosisDao = diagnosisDao;
	}

	public void setPendingResponseService(PendingResponseService responseService) {
		this.responseService = responseService;
	}
}
