package com.nisum.onboarding.jtable.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JTableOptionBean {

	@JsonProperty("DisplayText")
	private String displayText;
	
	@JsonProperty("Value")
	private String value;

	public JTableOptionBean(String displayTextAndValue) {
		setDisplayText(displayTextAndValue);
		setValue(displayTextAndValue);
	}
	
	public JTableOptionBean(String displayText, String value) {
		setDisplayText(displayText);
		setValue(value);
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
