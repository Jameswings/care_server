package com.cd.careserver.service.impl;

import com.cd.careserver.dao.DoctorDao;
import com.cd.careserver.po.Doctor;
import com.cd.careserver.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	private DoctorDao doctorDao;
	
	public Doctor getDoctorByUserId(String userId){
		return doctorDao.findByUserId(userId);
	}

	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}
}
