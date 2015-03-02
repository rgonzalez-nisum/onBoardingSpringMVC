package com.nisum.onboarding.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.awt.Color;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.RectangleBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

import com.nisum.onboarding.dto.ParticipantTaskReportDto;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.report.impl.GenericReportImpl;
import com.nisum.onboarding.report.util.ReportTemplates;

public class ParticipantTaskReport extends GenericReportImpl<ParticipantTaskReportDto> {

	private static final String REPORT_TITLE = "On-Boarding Progress Report";
	private static final String LOGO_FILEPATH = "/logo.png";
	private static final String DATEFORMAT_INFO = "yyyy-MM-dd";
	
	public ParticipantTaskReport() {
		super(REPORT_TITLE);
	}
	
	@Override
	protected void build() {
		RectangleBuilder background = getBackground(getStyleBuilder());
		JasperReportBuilder reportBuilder = report()
				.setPageFormat(PageType.LETTER, PageOrientation.LANDSCAPE)
				.setColumnStyle(ReportTemplates.columnStyle)
				.setColumnTitleStyle(ReportTemplates.boldCenteredStyle)
				.setColumnHeaderBackgroundComponent(background)
				.setDetailBackgroundComponent(background)
				.columns(getColumns())
				.title(getTitle())
				.pageFooter(ReportTemplates.footerComponent);
		
		setReportBuilder(reportBuilder);
	}
	
	private StyleBuilder getStyleBuilder() {
		return stl.style()
				.setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setRadius(10)
				.setBackgroundColor(new Color(226, 228, 255))
				.setLinePen(stl.pen().setLineColor(Color.WHITE));
	}
	
	private RectangleBuilder getBackground(StyleBuilder style) {
		return cmp.rectangle()
				.setStyle(style)
				.setPrintWhenExpression(exp.printInOddRow());
	}
	
	private VerticalListBuilder getTitle() {
		ImageBuilder logo = cmp.image(ParticipantTaskReport.class.getResourceAsStream(LOGO_FILEPATH)).setHorizontalAlignment(HorizontalAlignment.CENTER).setDimension(50, 50);
		TextFieldBuilder<String> title = Components.text(REPORT_TITLE)
				.setStyle(ReportTemplates.bold18CenteredStyle.setForegroundColor(new Color(58, 148, 210)).setBackgroundColor(new Color(255, 255, 255)))
				.setHorizontalAlignment(HorizontalAlignment.CENTER)
				.setHeight(35);
		
		return cmp.verticalList().add(logo, title);
	}
	
	private ColumnBuilder<?, ?>[] getColumns() {
		HorizontalAlignment center = HorizontalAlignment.CENTER;
		return new ColumnBuilder<?, ?>[] {
				col.column("Participant", "participantName", type.stringType()).setHorizontalAlignment(center),
				col.column("Program", "programDescription", type.stringType()).setHorizontalAlignment(center),
				col.column("Started on", "programStarted", type.dateType()).setPattern(DATEFORMAT_INFO).setHorizontalAlignment(center),
				col.column("Status", "programStatus", ProgramStatus.class).setHorizontalAlignment(center),
				col.column("Assigned", "assignedTasks", type.longType()).setHorizontalAlignment(center),
				col.column("Started", "startedTasks", type.longType()).setHorizontalAlignment(center),
				col.column("In Progress", "inProgressTasks", type.longType()).setHorizontalAlignment(center),
				col.column("Completed", "completedTasks", type.longType()).setHorizontalAlignment(center),
				col.column("Total", "totalTasks", type.longType()).setHorizontalAlignment(center)
			};
	}
	
}
