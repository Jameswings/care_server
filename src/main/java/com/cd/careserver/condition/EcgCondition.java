package com.cd.careserver.condition;

public class EcgCondition extends AbstractCondition {

	private String doctorId;
	private boolean unRead;
	
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

	public boolean isUnRead() {
		return unRead;
	}

	public void setUnRead(boolean unRead) {
		this.unRead = unRead;
	}
}
