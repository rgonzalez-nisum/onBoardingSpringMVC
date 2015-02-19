package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.jtable.bean.JTableParticipantBean;

public class JTableParticipantResponse extends JTableRecordResponseImpl<JTableParticipantBean> {

	public JTableParticipantResponse(String result) {
		super(result);
	}
	
	public JTableParticipantResponse(String result, JTableParticipantBean record) {
		super(result, record);
	}

	public JTableParticipantResponse(String result, String message) {
		super(result, message);
	}

}
