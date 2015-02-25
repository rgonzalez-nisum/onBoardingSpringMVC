package com.nisum.onboarding.jtable.response.impl;

import java.util.List;

import com.nisum.onboarding.dto.SerializableDto;
import com.nisum.onboarding.jtable.response.JTableRecordListResponse;

public abstract class JTableRecordListResponseImpl<T extends SerializableDto> extends JTableResponseImpl implements JTableRecordListResponse<T> {

	private List<T> records;
	private int totalRecordCount;

	public JTableRecordListResponseImpl(String result, String message) {
		setResult(result);
		setMessage(message);
	}
	
	public JTableRecordListResponseImpl(String result, List<T> records, int totalRecordCount) {
		setResult(result);
		setRecords(records);
		setTotalRecordCount(totalRecordCount);
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	
}
