package com.nisum.onboarding.dto.response;

import com.nisum.onboarding.model.Participant;

public class JsonJTableParticipantResponse extends AbstractJsonJTableResponse<Participant> {

	public JsonJTableParticipantResponse() {
		super();
	}

	public JsonJTableParticipantResponse(String result) {
		super(result);
	}

	public JsonJTableParticipantResponse(String result, String message) {
		super(result, message);
	}

	public JsonJTableParticipantResponse(String result, Participant record) {
		super(result, record);
	}

}
