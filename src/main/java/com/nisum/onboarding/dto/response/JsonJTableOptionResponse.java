package com.nisum.onboarding.dto.response;

import java.util.List;

import com.nisum.onboarding.dto.bean.JsonJTableOptionBean;

public class JsonJTableOptionResponse extends AbstractJsonJTableListResponse<JsonJTableOptionBean> {

	public JsonJTableOptionResponse(String result, String message) {
		super(result, message);
	}

	public JsonJTableOptionResponse(String result, List<JsonJTableOptionBean> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}

}
