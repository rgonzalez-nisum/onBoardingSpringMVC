package com.nisum.onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.onboarding.dto.ProgramDto;
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
	
	@RequestMapping(value = "/program-tasks")
	public ModelAndView programTasksByProgramtId(ModelMap model, @RequestParam(required=false) Long programId) throws BeanException {
		if (programId != null) {
			ProgramDto program = programService.findById(programId);
			if (program != null) {
				model.addAttribute("program", program);
			}
		}
		
		return new ModelAndView("program/program-tasks", model);
	}
	
}
