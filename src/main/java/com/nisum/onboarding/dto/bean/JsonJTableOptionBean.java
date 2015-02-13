package com.nisum.onboarding.dto.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonJTableOptionBean implements JsonJTableBean {

	@JsonProperty("DisplayText")
	private String displayText;

	@JsonProperty("Value")
	private String value;

	public JsonJTableOptionBean(String displayTextAndValue) {
		this.displayText = displayTextAndValue;
		this.value = displayTextAndValue;
	}
	
	public JsonJTableOptionBean(String displayText, String value) {
		this.displayText = displayText;
		this.value = value;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
