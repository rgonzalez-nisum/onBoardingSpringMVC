package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.model.Participant;

public class JTableParticipantResponse extends JTableRecordResponseImpl<Participant> {

	public JTableParticipantResponse() {
		super();
	}

	public JTableParticipantResponse(String result) {
		super(result);
	}

	public JTableParticipantResponse(String result, String message) {
		super(result, message);
	}

	public JTableParticipantResponse(String result, Participant record) {
		super(result, record);
	}

}
