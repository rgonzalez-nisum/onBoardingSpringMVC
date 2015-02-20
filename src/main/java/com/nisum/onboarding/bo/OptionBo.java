package com.nisum.onboarding.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface OptionBo extends SerializableBo {

	@JsonProperty("DisplayText")
	public String getDisplayText();

	public void setDisplayText(String displayText);

	@JsonProperty("Value")
	public Object getValue();

	public void setValue(Object value);

}
