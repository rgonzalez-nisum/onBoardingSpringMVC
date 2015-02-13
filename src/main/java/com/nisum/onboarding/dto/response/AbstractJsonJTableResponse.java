package com.nisum.onboarding.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractJsonJTableResponse<T> {

	@JsonProperty("Result")
	private String result;

	@JsonProperty("Record")
	private T record;

	@JsonProperty("Message")
	private String message;

	public AbstractJsonJTableResponse() {
	}

	public AbstractJsonJTableResponse(String result) {
		this.result = result;
	}

	public AbstractJsonJTableResponse(String result, T record) {
		this.result = result;
		this.record = record;
	}

	public AbstractJsonJTableResponse(String result, String message) {
		this.result = result;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public T getRecord() {
		return record;
	}

	public void setRecord(T record) {
		this.record = record;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
