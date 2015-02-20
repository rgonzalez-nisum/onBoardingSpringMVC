package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.bo.ProgramBo;

@SuppressWarnings("rawtypes")
public class JTableProgramResponse extends JTableRecordResponseImpl<ProgramBo> {

	public JTableProgramResponse(String result) {
		super(result);
	}

	public JTableProgramResponse(String result, ProgramBo record) {
		super(result, record);
	}

	public JTableProgramResponse(String result, String message) {
		super(result, message);
	}

}
