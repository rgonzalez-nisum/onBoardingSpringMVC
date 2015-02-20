package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.bo.TaskBo;

@SuppressWarnings("rawtypes")
public class JTableTaskResponse extends JTableRecordResponseImpl<TaskBo> {

	public JTableTaskResponse(String result) {
		super(result);
	}

	public JTableTaskResponse(String result, TaskBo record) {
		super(result, record);
	}

	public JTableTaskResponse(String result, String message) {
		super(result, message);
	}

}
