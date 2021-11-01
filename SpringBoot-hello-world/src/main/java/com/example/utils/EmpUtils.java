package com.example.utils;

public enum EmpUtils {
	
	NOT_FOUND("Data not found"),
	NOT_CREATED("Data not created in database"),
	CREATED("Data created in database successfully");
	
	private String msg;
	
	EmpUtils(String msg) {
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}
	

}
