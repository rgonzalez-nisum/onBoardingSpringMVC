package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.dto.ParticipantTaskReportDto;
import com.nisum.onboarding.service.TaskService;

@Controller
@RequestMapping("/reports")
public class ReportController {
	
private static final Logger LOG = Logger.getLogger(ReportController.class);
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/getParticipantTasks")
	@ResponseBody
	public List<ParticipantTaskReportDto> getAllTasks() {
		List<ParticipantTaskReportDto> taskBeans = new ArrayList<ParticipantTaskReportDto>();
		
		try {
			taskBeans = taskService.getParticipantsTaskReport();
		} catch (Exception e) {
			LOG.error("Exception", e);
		}

		return taskBeans;
	}

}
