package com.nisum.onboarding.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.onboarding.dto.bean.JsonJTableOptionBean;

public class JsonJTableOptionListResponse {

	@JsonProperty("Result")
	private String result;

	@JsonProperty("Options")
	private List<JsonJTableOptionBean> options;

	@JsonProperty("Message")
	private String message;

	public JsonJTableOptionListResponse(String result, List<JsonJTableOptionBean> options) {
		this.result = result;
		this.options = options;
	}

	public JsonJTableOptionListResponse(String result, String message) {
		this.result = result;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<JsonJTableOptionBean> getOptions() {
		return options;
	}

	public void setOptions(List<JsonJTableOptionBean> options) {
		this.options = options;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
