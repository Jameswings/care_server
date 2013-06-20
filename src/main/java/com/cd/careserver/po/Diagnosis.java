package com.cd.careserver.po;

import java.util.Date;

public class Diagnosis {
	private String id;
	private String doctorEcgId;
	private String message;
	private Date creationTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDoctorEcgId() {
		return doctorEcgId;
	}
	public void setDoctorEcgId(String doctorEcgId) {
		this.doctorEcgId = doctorEcgId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
}
