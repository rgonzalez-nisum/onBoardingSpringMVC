package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.jtable.bean.JTableTaskBean;

public class JTableTaskListResponse extends JTableRecordListResponseImpl<JTableTaskBean> {

	public JTableTaskListResponse(String result, String message) {
		super(result, message);
	}

	public JTableTaskListResponse(String result, List<JTableTaskBean> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}