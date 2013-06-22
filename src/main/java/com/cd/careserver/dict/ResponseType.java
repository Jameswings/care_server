package com.cd.careserver.dict;

public enum ResponseType {
	UNKNOWN(0), ECG(1), DIAGNOSIS(2);

	private int value;

	ResponseType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static ResponseType valueOf(int value) {
		switch (value) {
		case 1:
			return ECG;
		case 2:
			return DIAGNOSIS;
		default:
			return UNKNOWN;
		}
	}

	public String toI18nString() {
		switch (this) {
		case ECG:
			return "ECG";
		case DIAGNOSIS:
			return "Diagnosis";
		default:
			return this.toString();
		}
	}
}
