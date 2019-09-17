package com.rhc.jdg.domain;

import java.io.Serializable;

public class FirstClass implements Serializable {

	private static final long serialVersionUID = 5628080947302460205L;
	
	public String value;
	
	public FirstClass() {}
	
	public FirstClass(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
