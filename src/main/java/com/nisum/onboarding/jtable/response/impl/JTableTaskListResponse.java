package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.bo.TaskBo;

@SuppressWarnings("rawtypes")
public class JTableTaskListResponse extends JTableRecordListResponseImpl<TaskBo> {

	public JTableTaskListResponse(String result, String message) {
		super(result, message);
	}

	public JTableTaskListResponse(String result, List<TaskBo> records, int totalRecordCount) {
		super(result, records, totalRecordCount);
	}
	
}