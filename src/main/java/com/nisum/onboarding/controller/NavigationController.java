package com.nisum.onboarding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public ModelAndView homePage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value={"/test", "test"}, method=RequestMethod.GET)
	public ModelAndView testPage() {
		return new ModelAndView("test");
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
	public String programTasks(ModelMap model) {
		return "program/program-tasks";
	}
	
}
