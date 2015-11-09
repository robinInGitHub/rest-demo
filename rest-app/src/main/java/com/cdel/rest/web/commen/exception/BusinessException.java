package com.cdel.rest.web.commen.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BusinessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4245287762781543162L;
	
	private static Log log = LogFactory.getLog(BusinessException.class);
	
	public BusinessException() {
		super();
		log.debug(super.getMessage(), super.getCause());
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		log.debug(message, cause);
	}

	public BusinessException(String message) {
		super(message);
		log.debug(message, super.getCause());
	}

	public BusinessException(Throwable cause) {
		super(cause);
		log.debug(super.getMessage(), cause);
	}
	
}
