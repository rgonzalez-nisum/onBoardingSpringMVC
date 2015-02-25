package com.nisum.onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.service.ProgramService;

@Controller
public class NavigationController {

	@Autowired
	private ProgramService programService;
	
	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public String homePage() {
		return "index";
	}
	
	@RequestMapping(value={"/test", "test"}, method=RequestMethod.GET)
	public String testPage() {
		return "test";
	}
	
	@RequestMapping(value = "/participants", method = RequestMethod.GET)
	public String participants(ModelMap model) {
		return "participant/all-participants";
	}
	
	@RequestMapping(value = "/programs", method = RequestMethod.GET)
	public String programs(ModelMap model) {
		return "program/all-programs";
	}
	
	@RequestMapping(value = "/program-tasks", method = RequestMethod.GET)
	public String programTasks(ModelMap model) throws BeanException {
		return "program/program-tasks";
	}

	@RequestMapping(value = "/program-tasks/{programId}", method = RequestMethod.GET)
	public String programTasksByProgramtId(ModelMap model, @RequestParam(required=true) Long programId) throws BeanException {
		return "program/program-tasks";
	}
	
}
