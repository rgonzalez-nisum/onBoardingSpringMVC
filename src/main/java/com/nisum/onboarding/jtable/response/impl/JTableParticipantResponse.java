package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.bo.ParticipantBo;

@SuppressWarnings("rawtypes")
public class JTableParticipantResponse extends JTableRecordResponseImpl<ParticipantBo> {

	public JTableParticipantResponse(String result) {
		super(result);
	}
	
	public JTableParticipantResponse(String result, ParticipantBo record) {
		super(result, record);
	}

	public JTableParticipantResponse(String result, String message) {
		super(result, message);
	}

}
