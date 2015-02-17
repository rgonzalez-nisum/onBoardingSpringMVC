package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.model.Participant;

public class JTableParticipantListResponse extends JTableRecordListResponseImpl<Participant> {

	public JTableParticipantListResponse(String result, String message) {
		super(result, message);
	}

	public JTableParticipantListResponse(String result, List<Participant> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}
