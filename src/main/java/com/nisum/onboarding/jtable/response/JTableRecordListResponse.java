package com.nisum.onboarding.jtable.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.onboarding.dto.SerializableDto;

public interface JTableRecordListResponse<T extends SerializableDto> extends JTableResponse {
	
	@JsonProperty("Records")
	public List<T> getRecords();
	
	public void setRecords(List<T> records);
	
	@JsonProperty("TotalRecordCount")
	public int getTotalRecordCount();

	public void setTotalRecordCount(int totalRecordCount);

}
