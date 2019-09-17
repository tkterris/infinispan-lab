package com.rhc.jdg.domain;

import java.io.Serializable;

public class SecondClass implements Serializable {
	
	private static final long serialVersionUID = -8523844369339908576L;
	
	public String value;
	
	public SecondClass() {}
	
	public SecondClass(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
