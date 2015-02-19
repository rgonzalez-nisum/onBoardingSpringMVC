package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.jtable.bean.JTableProgramBean;

public class JTableProgramListResponse extends JTableRecordListResponseImpl<JTableProgramBean> {

	public JTableProgramListResponse(String result, String message) {
		super(result, message);
	}

	public JTableProgramListResponse(String result, List<JTableProgramBean> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}