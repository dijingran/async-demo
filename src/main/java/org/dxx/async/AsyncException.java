/**
 * AsyncException.java 上午10:15:00 2012-12-21
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package org.dxx.async;
/**
 * <p></p>
 * 
 * @author dixingxing	
 * @date 2012-12-21
 */
@SuppressWarnings("serial")
public class AsyncException extends RuntimeException{

	/**
	 * 
	 */
	public AsyncException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public AsyncException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param message
	 */
	public AsyncException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param cause
	 */
	public AsyncException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
