/*
 * <h4>Description</h4>
 * All business exceptions should be thrown using this class.
 *Amit Rathi
 */
package com.salido.labor.exception;

public class AppBusinessException extends AppException {

	private static final long serialVersionUID = -8817025373765348946L;

	public AppBusinessException(String key) {
		super(key, ErrorType.BUSINESS, null, "", new Throwable());
	}

	public AppBusinessException(String key, String[] args) {
		super(key, ErrorType.BUSINESS, args, "", new Throwable());
	}

	public AppBusinessException(String key, String defaultMessage) {
		super(key, ErrorType.BUSINESS, null, defaultMessage, new Throwable());
	}

	public AppBusinessException(String key, String[] args, String defaultMessage) {
		super(key, ErrorType.BUSINESS, args, defaultMessage, new Throwable());
	}
}
