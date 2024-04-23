package com.mycar.steerwheels.exception;

public class SteerWheelsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8111241118889841968L;
	
	private String errorCode;
	
	private String message;
	
	private String uniqueNo;
	
	public SteerWheelsException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public SteerWheelsException(String errorCode, String message, String uniqueNo) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.uniqueNo = uniqueNo;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUniqueNo() {
		return uniqueNo;
	}

	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}
	
	

}
