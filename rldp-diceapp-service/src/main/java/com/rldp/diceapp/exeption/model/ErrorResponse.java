package com.rldp.diceapp.exeption.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 12312321L;

	private final String code;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final List<String> messages;

	public ErrorResponse(String errorCode) {
		this.code = errorCode;
		messages = new ArrayList<>();
	}

	public ErrorResponse(String message, String errorCode) {
		this(Arrays.asList(message), errorCode);
	}

	public ErrorResponse(List<String> messages, String errorCode) {
		this.messages = messages;
		this.code = errorCode;
	}

	public String getCode() {
		return code;
	}

	public List<String> getMessages() {
		return messages;
	}
}
