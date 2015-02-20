package com.nisum.onboarding.bo.impl;

import com.nisum.onboarding.bo.OptionBo;

public class OptionBoImpl implements OptionBo {

	private static final long serialVersionUID = 1340946921988217674L;
	
	private String displayText;
	private Object value;

	public OptionBoImpl(String displayTextAndValue) {
		setDisplayText(displayTextAndValue);
		setValue(displayTextAndValue);
	}
	
	public OptionBoImpl(String displayText, Object value) {
		setDisplayText(displayText);
		setValue(value);
	}

	@Override
	public String getDisplayText() {
		return displayText;
	}

	@Override
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = value;
	}

}
