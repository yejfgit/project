package com.survey.util;


/**
 * @author  yijt
 */
public class UlicException extends Exception {

	private int errorCode=-1;
	
	private String errorType = "";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UlicException() {
		super();
	}

	public UlicException(String message) {
		super(message);
	}
	
	public UlicException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	public UlicException(String message, String errorType) {
		super(message);
		this.errorType = errorType; 
	}
	public UlicException(String message, Throwable cause) {
		super(message, cause);
	}

	public UlicException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return  the errorCode
	 * @uml.property  name="errorCode"
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode  the errorCode to set
	 * @uml.property  name="errorCode"
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return  the errorType
	 * @uml.property  name="errorType"
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * @param errorType  the errorType to set
	 * @uml.property  name="errorType"
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
}
