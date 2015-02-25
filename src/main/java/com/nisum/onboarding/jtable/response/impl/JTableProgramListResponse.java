package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.dto.ProgramDto;

public class JTableProgramListResponse extends JTableRecordListResponseImpl<ProgramDto> {

	public JTableProgramListResponse(String result, String message) {
		super(result, message);
	}

	public JTableProgramListResponse(String result, List<ProgramDto> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}