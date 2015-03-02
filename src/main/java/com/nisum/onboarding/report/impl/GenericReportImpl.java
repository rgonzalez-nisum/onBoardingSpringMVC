package com.nisum.onboarding.report.impl;

import java.io.File;
import java.io.OutputStream;
import java.util.Collection;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.Exporters;
import net.sf.dynamicreports.report.exception.DRException;

import com.nisum.onboarding.dto.SerializableDto;
import com.nisum.onboarding.report.GenericReport;

public abstract class GenericReportImpl<T extends SerializableDto> implements GenericReport<T> {

	private String reportName;
	private Collection<T> dataSource;
	private JasperReportBuilder reportBuilder;

	public GenericReportImpl(String reportName) {
		setReportName(reportName);
		build();
	}

	@Override
	public String getReportName() {
		return reportName;
	}

	@Override
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	@Override
	public Collection<T> getDataSource() {
		return dataSource;
	}

	@Override
	public void setDataSource(Collection<T> dataSource) {
		this.dataSource = dataSource;
		reportBuilder.setDataSource(dataSource);
	}

	@Override
	public void viewAsPdf(OutputStream outputStream) throws Exception {
		try {
			reportBuilder.toPdf(outputStream);
		} catch (DRException e) {
			throw new Exception("An error ocurred generating report", e);
		}
	}

	@Override
	public void exportToPdf(String exportPath) throws Exception {
		try {
			reportBuilder.toPdf(Exporters.pdfExporter(new File(exportPath + getReportName()
					+ ".pdf")));
		} catch (DRException e) {
			throw new Exception("An error ocurred exporting report", e);
		}
	}

	protected JasperReportBuilder getReportBuilder() {
		return reportBuilder;
	}

	protected void setReportBuilder(JasperReportBuilder reportBuilder) {
		this.reportBuilder = reportBuilder;
	}

	protected abstract void build();

}
