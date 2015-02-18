package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.model.Program;

public class JTableProgramListResponse extends JTableRecordListResponseImpl<Program> {

	public JTableProgramListResponse(String result, String message) {
		super(result, message);
	}

	public JTableProgramListResponse(String result, List<Program> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}