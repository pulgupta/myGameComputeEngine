package com.klgs.rest.gameEngine.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ExceptionHandlers {

	private static Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);
	
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)  // 415
	public void handleConflict() {
		log.debug("This is indeed called");
	}
}
