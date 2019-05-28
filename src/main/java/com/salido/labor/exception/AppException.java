/*
 * <h4>Description</h4>
 * Base class for custom exceptions
 *Amit Rathi
 */
package com.salido.labor.exception;

public abstract class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String key;
	private final ErrorType errType;
	private final String[] errorArgs;
	private final String defaultMessage;

	public AppException(String key, ErrorType errType, String[] errorArgs, String defaultMessage,
			final Throwable cause) {
		super(key, cause);
		this.key = key;
		this.errType = errType;
		this.errorArgs = errorArgs != null ? (String[]) errorArgs.clone() : null;
		this.defaultMessage = defaultMessage;
	}

	public ErrorType getErrType() {
		return errType;
	}

	public String getKey() {
		return key;
	}

	public String[] getErrorArgs() {
		return errorArgs != null ? (String[]) errorArgs.clone() : null;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}
}
