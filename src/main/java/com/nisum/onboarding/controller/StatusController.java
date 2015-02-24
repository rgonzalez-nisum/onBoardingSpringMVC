package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.bo.impl.OptionBoImpl;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.model.TaskStatus;

@Controller
@RequestMapping("/statuses")
public class StatusController {
	
	@RequestMapping(value = "/getAllProgramStatusesAsOptions", method = RequestMethod.POST)
	@ResponseBody
	public JTableOptionListResponseImpl getAllProgramStatusesAsOptions() {
		List<OptionBoImpl> statuses = findAllProgramStatusesAsOptions();
		
		return new JTableOptionListResponseImpl("OK", statuses);
	}
	
	@RequestMapping(value = "/getAllTaskStatusesAsOptions", method = RequestMethod.POST)
	@ResponseBody
	public JTableOptionListResponseImpl getAllTaskStatusesAsOptions() {
		List<OptionBoImpl> statuses = findAllTaskStatusesAsOptions();
		
		return new JTableOptionListResponseImpl("OK", statuses);
	}
	
	private List<OptionBoImpl> findAllProgramStatusesAsOptions() {
		List<OptionBoImpl> statuses = new ArrayList<OptionBoImpl>();
		
		for (ProgramStatus status : ProgramStatus.values()) {
			statuses.add(new OptionBoImpl(status.toString()));
		}

		return statuses;
	}
	
	private List<OptionBoImpl> findAllTaskStatusesAsOptions() {
		List<OptionBoImpl> statuses = new ArrayList<OptionBoImpl>();
		
		for (TaskStatus status : TaskStatus.values()) {
			statuses.add(new OptionBoImpl(status.toString()));
		}

		return statuses;
	}

}
