package com.cd.careserver.dict;

public enum UserType {
	DOCTOR(1), CUSTOMER(2), UNKNOWN(0);

	private int value;
	
	UserType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public static UserType valueOf(int value) {
		switch (value) {
		case 1:
			return DOCTOR;
		case 2:
			return CUSTOMER;
		default:
			return UNKNOWN;
		}
	}

	public String toI18nString() {
		switch (this) {
		case DOCTOR:
			return "doctor";
		case CUSTOMER:
			return "customer";
		default:
			return this.toString();
		}
	}
}
