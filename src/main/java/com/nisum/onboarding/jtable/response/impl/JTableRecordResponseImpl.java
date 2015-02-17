package com.nisum.onboarding.jtable.response.impl;

import com.nisum.onboarding.jtable.response.JTableRecordResponse;

public abstract class JTableRecordResponseImpl<T> extends JTableResponseImpl implements JTableRecordResponse<T> {

	private T record;

	public JTableRecordResponseImpl() {
	}

	public JTableRecordResponseImpl(String result) {
		setResult(result);
	}

	public JTableRecordResponseImpl(String result, T record) {
		setResult(result);
		setRecord(record);
	}

	public JTableRecordResponseImpl(String result, String message) {
		setResult(result);
		setMessage(message);
	}

	@Override
	public T getRecord() {
		return record;
	}

	@Override
	public void setRecord(T record) {
		this.record = record;
	}

}
