package com.cd.careserver.service;

import com.cd.careserver.po.Doctor;

public interface DoctorService {

	Doctor getDoctorByUserId(String userId);

	String addDoctor(Doctor doctor);

}
