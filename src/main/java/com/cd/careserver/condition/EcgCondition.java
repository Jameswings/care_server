package com.cd.careserver.condition;

public class EcgCondition extends AbstractCondition {

	private String doctorId;
	private boolean isRead;
	
	@Override
	public boolean isUsePaging() {
		return false;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
}
