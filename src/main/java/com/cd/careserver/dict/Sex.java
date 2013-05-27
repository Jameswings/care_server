package com.cd.careserver.dict;

public enum Sex {
	MALE(1), FEMALE(2), UNKNOWN(0);

	private int value;

	Sex(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Sex valueOf(int value) {
		switch (value) {
		case 1:
			return MALE;
		case 2:
			return FEMALE;
		default:
			return UNKNOWN;
		}
	}

	public String toI18nString() {
		switch (this) {
		case MALE:
			return "male";
		case FEMALE:
			return "female";
		default:
			return this.toString();
		}
	}
}
