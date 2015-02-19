package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.jtable.bean.JTableProgramBean;

public class JTableProgramResponse extends JTableRecordResponseImpl<JTableProgramBean> {

	public JTableProgramResponse(String result) {
		super(result);
	}

	public JTableProgramResponse(String result, JTableProgramBean record) {
		super(result, record);
	}

	public JTableProgramResponse(String result, String message) {
		super(result, message);
	}

}
