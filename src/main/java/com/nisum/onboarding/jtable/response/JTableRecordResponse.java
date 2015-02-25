package com.nisum.onboarding.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.onboarding.dto.SerializableDto;

public interface JTableRecordResponse<T extends SerializableDto> extends JTableResponse {

	@JsonProperty("Record")
	public T getRecord();
	
	public void setRecord(T record);
	
}
