package com.cisco.cjp.org.management.exception;


public class OrgNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public OrgNotFoundException(String exception) {
		super(exception);
	}
}
