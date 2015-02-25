package com.nisum.onboarding.jtable.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.onboarding.dto.OptionDto;

public interface JTableOptionListResponse extends JTableResponse {
	
	@JsonProperty("Options")
	public List<OptionDto> getOptions();
	
	public void setOptions(List<OptionDto> options);
	
}
