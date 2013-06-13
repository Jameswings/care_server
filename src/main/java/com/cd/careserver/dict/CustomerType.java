package com.cd.careserver.dict;

public enum CustomerType {
	NORMAL(1), VIP(2), UNKNOWN(0);
	
	private int value;
	
	CustomerType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public static CustomerType valueOf(int value) {
		switch (value) {
		case 1:
			return NORMAL;
		case 2:
			return VIP;
		default:
			return UNKNOWN;	
		}
	}

	public String toI18nString() {
		switch (this) {
		case NORMAL:
			return "Normal";
		case VIP:
			return "VIP";
		default:
			return this.toString();
		}
	}
}
