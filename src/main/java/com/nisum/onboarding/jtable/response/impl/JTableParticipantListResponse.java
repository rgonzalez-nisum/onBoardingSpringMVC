package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.jtable.bean.JTableParticipantBean;

public class JTableParticipantListResponse extends JTableRecordListResponseImpl<JTableParticipantBean> {

	public JTableParticipantListResponse(String result, String message) {
		super(result, message);
	}

	public JTableParticipantListResponse(String result, List<JTableParticipantBean> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}
