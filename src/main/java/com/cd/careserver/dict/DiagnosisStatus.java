package com.cd.careserver.dict;

public enum DiagnosisStatus {
	INIT(0), REPLY(1);

	private int value;

	DiagnosisStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static DiagnosisStatus valueOf(int value) {
		switch (value) {
		case 1:
			return REPLY;
		case 0:
			return INIT;
		default:
			return null;
		}
	}

	public String toI18nString() {
		switch (this) {
		case REPLY:
			return "Replied";
		case INIT:
			return "Init";
		default:
			return this.toString();
		}
	}
}
