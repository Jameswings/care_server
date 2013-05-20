package com.cd.careserver.dao;

import java.util.List;

import com.cd.careserver.po.Doctor;

public interface DoctorDao {

	Doctor findById(String doctorId);

	String update(Doctor doctor);

	String delete(String doctorId);

	String insert(Doctor doctor);

	List<Doctor> findAll();
}
