package com.nisum.onboarding.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractJsonJTableListResponse<T> {

	@JsonProperty("Result")
	private String result;

	@JsonProperty("Records")
	private List<T> records;

	@JsonProperty("TotalRecordCount")
	private int totalRecordCount;

	@JsonProperty("Message")
	private String message;

	public AbstractJsonJTableListResponse(String result, String message) {
		this.result = result;
		this.message = message;
	}
	
	public AbstractJsonJTableListResponse(String result, List<T> records, int totalRecordCount) {
		this.result = result;
		this.records = records;
		this.totalRecordCount = totalRecordCount;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
