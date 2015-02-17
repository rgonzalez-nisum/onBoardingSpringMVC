package com.nisum.onboarding.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface JTableResponse {
	
	@JsonProperty("Result")
	public String getResult();

	public void setResult(String result);

	@JsonProperty("Message")
	public String getMessage();

	public void setMessage(String message);

}
