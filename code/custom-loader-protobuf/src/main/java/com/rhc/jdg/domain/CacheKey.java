package com.rhc.jdg.domain;

public class CacheKey {
	private String index;
	private String keyField;
	
	public CacheKey() {}
	public CacheKey(String index, String keyField) {
		this.index = index;
		this.keyField = keyField;
	}
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getKeyField() {
		return keyField;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
}
