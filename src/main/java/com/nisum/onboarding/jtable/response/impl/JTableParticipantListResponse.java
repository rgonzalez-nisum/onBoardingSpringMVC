package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.bo.ParticipantBo;

@SuppressWarnings("rawtypes")
public class JTableParticipantListResponse extends JTableRecordListResponseImpl<ParticipantBo> {

	public JTableParticipantListResponse(String result, String message) {
		super(result, message);
	}

	public JTableParticipantListResponse(String result, List<ParticipantBo> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}
