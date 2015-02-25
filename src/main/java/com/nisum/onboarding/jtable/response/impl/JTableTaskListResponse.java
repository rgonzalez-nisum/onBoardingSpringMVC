package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.dto.TaskDto;

public class JTableTaskListResponse extends JTableRecordListResponseImpl<TaskDto> {

	public JTableTaskListResponse(String result, String message) {
		super(result, message);
	}

	public JTableTaskListResponse(String result, List<TaskDto> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}