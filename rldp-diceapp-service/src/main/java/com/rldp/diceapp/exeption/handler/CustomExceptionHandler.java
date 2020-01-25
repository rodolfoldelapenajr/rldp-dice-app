package com.rldp.diceapp.exeption.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rldp.diceapp.exeption.model.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = { BindException.class })
	public ResponseEntity<ErrorResponse> customHttpException(BindException ex) {
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		ErrorResponse body = new ErrorResponse(errors, HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
}
