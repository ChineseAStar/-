package com.test;

public class LeaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LeaseException(){
		
	}

	public LeaseException(String msg){
		super(msg);
	}
	
	public LeaseException(Exception e){
		super(e);
	}
	
}
