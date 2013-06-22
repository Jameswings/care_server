package com.cd.careserver.dao;

import java.util.List;

import com.cd.careserver.po.Diagnosis;

public interface DiagnosisDao {

	Diagnosis findById(String diagnosisId);

	String update(Diagnosis diagnosis);

	String delete(String diagnosisId);

	String insert(Diagnosis diagnosis);

	List<Diagnosis> findAll();

	Diagnosis findByEcgIdAndDoctorId(String diaId, String doctorId);

}
