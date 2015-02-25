package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.dto.OptionDto;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.model.TaskStatus;

@Controller
@RequestMapping("/statuses")
public class StatusController {
	
	@RequestMapping(value = "/getAllProgramStatusesAsOptions", method = RequestMethod.POST)
	@ResponseBody
	public JTableOptionListResponseImpl getAllProgramStatusesAsOptions() {
		List<OptionDto> statuses = findAllProgramStatusesAsOptions();
		
		return new JTableOptionListResponseImpl("OK", statuses);
	}
	
	@RequestMapping(value = "/getAllTaskStatusesAsOptions", method = RequestMethod.POST)
	@ResponseBody
	public JTableOptionListResponseImpl getAllTaskStatusesAsOptions() {
		List<OptionDto> statuses = findAllTaskStatusesAsOptions();
		
		return new JTableOptionListResponseImpl("OK", statuses);
	}
	
	private List<OptionDto> findAllProgramStatusesAsOptions() {
		List<OptionDto> statuses = new ArrayList<OptionDto>();
		
		for (ProgramStatus status : ProgramStatus.values()) {
			statuses.add(new OptionDto(status.toString()));
		}

		return statuses;
	}
	
	private List<OptionDto> findAllTaskStatusesAsOptions() {
		List<OptionDto> statuses = new ArrayList<OptionDto>();
		
		for (TaskStatus status : TaskStatus.values()) {
			statuses.add(new OptionDto(status.toString()));
		}

		return statuses;
	}

}
