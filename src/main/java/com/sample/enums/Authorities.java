package com.sample.enums;

public enum Authorities {

	ROLE_USER(1),ROLE_ADMIN(2);
	
	private Integer value;

	private Authorities(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
	}

}
