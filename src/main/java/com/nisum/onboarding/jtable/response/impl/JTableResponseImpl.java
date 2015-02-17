package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.jtable.response.JTableResponse;

public abstract class JTableResponseImpl implements JTableResponse {

	private String result;
	private String message;
	
	@Override
	public String getResult() {
		return result;
	}

	@Override
	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

}
