/*
 * <h4>Description</h4>
 * All system exception are wrapped to this class.
 */
package com.salido.labor.exception;

public class AppSystemException extends AppException {

	private static final long serialVersionUID = 2763187418243954651L;

	public AppSystemException(String key, String[] args, String defaultMessage) {
		super(key, ErrorType.BUSINESS, args, defaultMessage, new Throwable());
	}

	public AppSystemException(String key) {
		super(key, ErrorType.BUSINESS, null, "", new Throwable());
	}

	public AppSystemException(String key, String[] args) {
		super(key, ErrorType.BUSINESS, args, "", new Throwable());
	}

	public AppSystemException(String key, String defaultMessage) {
		super(key, ErrorType.BUSINESS, null, defaultMessage, new Throwable());
	}

	public AppSystemException(String key, Throwable th) {
		super(key, ErrorType.BUSINESS, null, null, th);
	}

	public AppSystemException(String key, Throwable th, String defaultMessage) {
		super(key, ErrorType.BUSINESS, null, defaultMessage, th);
	}

	public AppSystemException(String key, String[] args, Throwable th, String defaultMessage) {
		super(key, ErrorType.BUSINESS, args, defaultMessage, th);
	}
}
