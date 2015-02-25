package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.dto.TaskDto;

public class JTableTaskResponse extends JTableRecordResponseImpl<TaskDto> {

	public JTableTaskResponse(String result) {
		super(result);
	}

	public JTableTaskResponse(String result, TaskDto record) {
		super(result, record);
	}

	public JTableTaskResponse(String result, String message) {
		super(result, message);
	}

}
