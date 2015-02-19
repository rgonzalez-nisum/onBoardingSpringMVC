package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.jtable.bean.JTableTaskBean;

public class JTableTaskResponse extends JTableRecordResponseImpl<JTableTaskBean> {

	public JTableTaskResponse(String result) {
		super(result);
	}

	public JTableTaskResponse(String result, JTableTaskBean record) {
		super(result, record);
	}

	public JTableTaskResponse(String result, String message) {
		super(result, message);
	}

}
