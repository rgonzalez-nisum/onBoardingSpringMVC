package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.dto.ParticipantDto;

public class JTableParticipantResponse extends JTableRecordResponseImpl<ParticipantDto> {

	public JTableParticipantResponse(String result) {
		super(result);
	}
	
	public JTableParticipantResponse(String result, ParticipantDto record) {
		super(result, record);
	}

	public JTableParticipantResponse(String result, String message) {
		super(result, message);
	}

}
