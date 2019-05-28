/*
 * <h4>Description</h4>
 * All business exceptions should be thrown using this class.
 *Amit Rathi
 */
package com.salido.labor.exception;

public class SalidoLaborBusinessException extends AppException {

	private static final long serialVersionUID = -8817025373765348946L;

	public SalidoLaborBusinessException(String key) {
		super(key, ErrorType.BUSINESS, null, "", new Throwable());
	}

	public SalidoLaborBusinessException(String key, String[] args) {
		super(key, ErrorType.BUSINESS, args, "", new Throwable());
	}

	public SalidoLaborBusinessException(String key, String defaultMessage) {
		super(key, ErrorType.BUSINESS, null, defaultMessage, new Throwable());
	}

	public SalidoLaborBusinessException(String key, String[] args, String defaultMessage) {
		super(key, ErrorType.BUSINESS, args, defaultMessage, new Throwable());
	}
}
