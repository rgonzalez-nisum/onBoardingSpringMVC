package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.dto.ProgramDto;

public class JTableProgramResponse extends JTableRecordResponseImpl<ProgramDto> {

	public JTableProgramResponse(String result) {
		super(result);
	}

	public JTableProgramResponse(String result, ProgramDto record) {
		super(result, record);
	}

	public JTableProgramResponse(String result, String message) {
		super(result, message);
	}

}
