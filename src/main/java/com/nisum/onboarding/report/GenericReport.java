package com.nisum.onboarding.report;

import java.io.OutputStream;
import java.util.Collection;

import com.nisum.onboarding.dto.SerializableDto;

public interface GenericReport<T extends SerializableDto> {

	public String getReportName();
	
	public void setReportName(String reportName);
	
	public Collection<T> getDataSource();
	
	public void setDataSource(Collection<T> dataSource);
	
	public void viewAsPdf(OutputStream outputStream) throws Exception;
	
	public void exportToPdf(String exportPath) throws Exception;

}
