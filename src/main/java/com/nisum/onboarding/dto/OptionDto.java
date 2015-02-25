package com.nisum.onboarding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionDto implements SerializableDto {

	private static final long serialVersionUID = 1662042079895753524L;

	@JsonProperty("DisplayText")
	private String displayText;
	
	@JsonProperty("Value")
	private Object value;

	public OptionDto(String displayTextAndValue) {
		setDisplayText(displayTextAndValue);
		setValue(displayTextAndValue);
	}
	
	public OptionDto(String displayText, Object value) {
		setDisplayText(displayText);
		setValue(value);
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
