package com.cd.careserver.service;

import com.cd.careserver.po.Diagnosis;

public interface DiagnosisService {

	Diagnosis getDiagnosis(String ecgId, String docId);

	String saveDiagnosis(Diagnosis diagnosis);

	Diagnosis getDiagnosisById(String diaId);
	
}
