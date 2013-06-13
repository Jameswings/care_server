package com.cd.careserver.dict;

public enum UserStatus {
	INIT(0), ACTIVE(1), INACTIVE(-1);
	
	private int value;
	
	UserStatus(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public static UserStatus valueOf(int value) {
		switch (value) {
		case 1:
			return ACTIVE;
		case -1:
			return INACTIVE;
		default:
			return INIT;	
		}
	}

	public String toI18nString() {
		switch (this) {
		case ACTIVE:
			return "Active";
		case INACTIVE:
			return "Inactive";
		default:
			return this.toString();
		}
	}
}
