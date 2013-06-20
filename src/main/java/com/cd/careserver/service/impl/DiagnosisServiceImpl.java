package com.cd.careserver.service.impl;

import com.cd.careserver.dao.DiagnosisDao;
import com.cd.careserver.service.DiagnosisService;

public class DiagnosisServiceImpl implements DiagnosisService {

	private DiagnosisDao diagnosisDao;

	public void setDiagnosisDao(DiagnosisDao diagnosisDao) {
		this.diagnosisDao = diagnosisDao;
	}
}
