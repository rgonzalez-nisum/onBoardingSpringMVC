package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.dto.ParticipantDto;

public class JTableParticipantListResponse extends JTableRecordListResponseImpl<ParticipantDto> {

	public JTableParticipantListResponse(String result, String message) {
		super(result, message);
	}

	public JTableParticipantListResponse(String result, List<ParticipantDto> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}