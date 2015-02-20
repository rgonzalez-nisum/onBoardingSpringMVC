package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.bo.ProgramBo;

@SuppressWarnings("rawtypes")
public class JTableProgramListResponse extends JTableRecordListResponseImpl<ProgramBo> {

	public JTableProgramListResponse(String result, String message) {
		super(result, message);
	}

	public JTableProgramListResponse(String result, List<ProgramBo> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}