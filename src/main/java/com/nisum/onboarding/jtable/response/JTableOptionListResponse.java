package com.nisum.onboarding.jtable.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.onboarding.bo.OptionBo;

public interface JTableOptionListResponse<T extends OptionBo> extends JTableResponse {
	
	@JsonProperty("Options")
	public List<T> getOptions();
	
	public void setOptions(List<T> options);
	
}
