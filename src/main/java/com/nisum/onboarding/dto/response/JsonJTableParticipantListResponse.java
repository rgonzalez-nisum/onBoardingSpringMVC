package com.nisum.onboarding.dto.response;

import java.util.List;

import com.nisum.onboarding.dto.bean.JsonJTableParticipantBean;

public class JsonJTableParticipantListResponse extends AbstractJsonJTableListResponse<JsonJTableParticipantBean> {

	public JsonJTableParticipantListResponse(String result, String message) {
		super(result, message);
	}

	public JsonJTableParticipantListResponse(String result, List<JsonJTableParticipantBean> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}
