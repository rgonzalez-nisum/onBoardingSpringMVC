package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.jtable.bean.JTableOptionBean;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;
import com.nisum.onboarding.jtable.response.impl.JTableProgramListResponse;
import com.nisum.onboarding.jtable.response.impl.JTableProgramResponse;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.service.ProgramService;

@Controller
@RequestMapping("/programs")
public class ProgramController {

	@Autowired
	private ProgramService programService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String show(ModelMap model) {
		return "program/programs";
	}
	
	@RequestMapping(value = "/getAllPrograms", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramListResponse getAllPrograms(String jtSorting) {
		JTableProgramListResponse response;

		try {
			List<Program> programs = programService.findAll();
			response = new JTableProgramListResponse("OK", programs, programs.size());
		} catch (Exception e) {
			response = new JTableProgramListResponse("ERROR", e.getMessage());
		}

		return response;
	}

	@RequestMapping(value = "/statuses", method = RequestMethod.POST)
	public @ResponseBody JTableOptionListResponseImpl getPositions() {
		List<JTableOptionBean> statuses = allStatuses();
		return new JTableOptionListResponseImpl("OK", statuses);
	}

	@RequestMapping(value = "/addProgram", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse addProgram(@ModelAttribute Program program, BindingResult result) {
		if (result.hasErrors()) {
			return new JTableProgramResponse("ERROR", "Form invalid");
		}

		JTableProgramResponse jsonJtableResponse;
		
		try {
			programService.save(program);
			jsonJtableResponse = new JTableProgramResponse("OK", program);
		} catch (Exception e) {
			jsonJtableResponse = new JTableProgramResponse("ERROR", e.getMessage());
		}

		return jsonJtableResponse;
	}

	@RequestMapping(value = "/updateProgram", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse updateProgram(@ModelAttribute Program program, BindingResult result) {
		if (result.hasErrors()) {
			return new JTableProgramResponse("ERROR", "Form invalid");
		}

		JTableProgramResponse jsonJtableResponse;

		try {
			programService.update(program);
			jsonJtableResponse = new JTableProgramResponse("OK", program);
		} catch (Exception e) {
			jsonJtableResponse = new JTableProgramResponse("ERROR", e.getMessage());
		}
		
		return jsonJtableResponse;
	}

	@RequestMapping(value = "/deleteProgram", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse deleteProgram(@RequestParam Long id) {
		JTableProgramResponse jsonJtableResponse;
		
		try {
			programService.deleteById(id);
			jsonJtableResponse = new JTableProgramResponse("OK");
		} catch (Exception e) {
			jsonJtableResponse = new JTableProgramResponse("ERROR", e.getMessage());
		}
		
		return jsonJtableResponse;
	}

	private List<JTableOptionBean> allStatuses() {
		List<JTableOptionBean> positions = new ArrayList<JTableOptionBean>();
		for (ProgramStatus status : ProgramStatus.values()) {
			positions.add(new JTableOptionBean(status.toString()));
		}

		return positions;
	}
	
}
