package com.nisum.onboarding.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.onboarding.bo.SerializableBo;

public interface JTableRecordResponse<T extends SerializableBo> extends JTableResponse {

	@JsonProperty("Record")
	public T getRecord();
	
	public void setRecord(T record);
	
}
