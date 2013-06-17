package com.cd.careserver.dao;

import com.cd.careserver.po.DoctorEcg;

public interface DoctorEcgDao {

	DoctorEcg findById(String doctorEcgId);

	String update(DoctorEcg doctorEcg);

	String delete(String doctorEcgId);

	String insert(DoctorEcg doctorEcg);

}
