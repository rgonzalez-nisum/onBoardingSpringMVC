package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.dto.OptionDto;
import com.nisum.onboarding.jtable.response.JTableOptionListResponse;

public class JTableOptionListResponseImpl implements JTableOptionListResponse {

	private String result;
	private List<OptionDto> options;
	private String message;

	public JTableOptionListResponseImpl(String result, List<OptionDto> options) {
		this.result = result;
		this.options = options;
	}

	public JTableOptionListResponseImpl(String result, String message) {
		this.result = result;
		this.message = message;
	}

	@Override
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<OptionDto> getOptions() {
		return options;
	}

	public void setOptions(List<OptionDto> options) {
		this.options = options;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
