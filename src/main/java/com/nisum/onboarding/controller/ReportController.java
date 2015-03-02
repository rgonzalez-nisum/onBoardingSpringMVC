package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.dto.ParticipantTaskReportDto;
import com.nisum.onboarding.report.ParticipantTaskReport;
import com.nisum.onboarding.service.TaskService;

@Controller
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/getParticipantTasks")
	@ResponseBody
	public void getAllTasks(HttpServletResponse response) throws Exception {
		List<ParticipantTaskReportDto> reportDataSource = new ArrayList<ParticipantTaskReportDto>();

		reportDataSource = taskService.getParticipantsTaskReport();

		ParticipantTaskReport report = new ParticipantTaskReport();
		report.setDataSource(reportDataSource);

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + report.getReportName() + ".pdf");
		report.viewAsPdf(response.getOutputStream());
	}

}
