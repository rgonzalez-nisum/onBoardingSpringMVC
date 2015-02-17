package com.nisum.onboarding.jtable.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.onboarding.jtable.bean.JTableOptionBean;

public interface JTableOptionListResponse<T extends JTableOptionBean> extends JTableResponse {
	
	@JsonProperty("Options")
	public List<T> getOptions();
	
	public void setOptions(List<T> options);
	
}
