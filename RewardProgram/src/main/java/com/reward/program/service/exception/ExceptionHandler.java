package com.reward.program.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler({RewardException.class})
	public final ResponseEntity<Exception> handleRewardsException(RewardException ex)
	{
		return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
