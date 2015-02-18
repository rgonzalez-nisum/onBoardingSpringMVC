package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.model.Program;

public class JTableProgramResponse extends JTableRecordResponseImpl<Program> {

	public JTableProgramResponse(String result) {
		super(result);
	}

	public JTableProgramResponse(String result, Program record) {
		super(result, record);
	}

	public JTableProgramResponse(String result, String message) {
		super(result, message);
	}

}
