package com.nisum.onboarding.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface JTableRecordResponse<T> extends JTableResponse {

	@JsonProperty("Record")
	public T getRecord();
	
	public void setRecord(T record);
	
}
