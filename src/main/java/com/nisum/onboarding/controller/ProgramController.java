package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.bean.JTableOptionBean;
import com.nisum.onboarding.jtable.bean.JTableProgramBean;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;
import com.nisum.onboarding.jtable.response.impl.JTableProgramListResponse;
import com.nisum.onboarding.jtable.response.impl.JTableProgramResponse;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.service.ParticipantService;
import com.nisum.onboarding.service.ProgramService;

@Controller
@RequestMapping("/programs")
public class ProgramController {

	private static final Logger LOG = Logger.getLogger(ProgramController.class);
	
	@Autowired
	private ProgramService programService;
	@Autowired
	private ParticipantService participantService;

	@RequestMapping(value = "/getAllPrograms", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramListResponse getAllPrograms(String jtSorting) {
		JTableProgramListResponse response;

		try {
			List<JTableProgramBean> programBeans = programService.findAll();
			
			response = new JTableProgramListResponse("OK", programBeans, programBeans.size());
		} catch (Exception e) {
			LOG.error("Exception while finding all programs", e);
			response = new JTableProgramListResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}
	
	@RequestMapping(value = "/getProgramById", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse getProgramById(@RequestParam Long id) {
		JTableProgramResponse response;

		try {
			JTableProgramBean programBean = programService.findById(id);
			
			response = new JTableProgramResponse("OK", programBean);
		} catch (Exception e) {
			LOG.error("Exception while finding programs by ID", e);
			response = new JTableProgramResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}
	
	@RequestMapping(value = "/getProgramByParticipantId", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramListResponse getProgramByParticipantId(@RequestParam Long participantId) {
		JTableProgramListResponse response;

		try {
			List<JTableProgramBean> programBeans = programService.findByParticipantId(participantId);
			
			response = new JTableProgramListResponse("OK", programBeans, programBeans.size());
		} catch (Exception e) {
			LOG.error("Exception while finding programs by participant ID", e);
			response = new JTableProgramListResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}

	@RequestMapping(value = "/participants", method = RequestMethod.POST)
	public @ResponseBody JTableOptionListResponseImpl getParticipants() throws BeanException {
		List<JTableOptionBean> options = participantService.findAllAsOptions();
		return new JTableOptionListResponseImpl("OK", options);
	}
	
	@RequestMapping(value = "/statuses", method = RequestMethod.POST)
	public @ResponseBody JTableOptionListResponseImpl getPositions() {
		List<JTableOptionBean> statuses = allStatuses();
		return new JTableOptionListResponseImpl("OK", statuses);
	}
	
	@RequestMapping(value = "/addProgram", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse addProgram(@ModelAttribute JTableProgramBean programBean, BindingResult result) {
		if (result.hasErrors()) {
			LOG.error(result.getAllErrors());
			return new JTableProgramResponse("ERROR", "Form invalid");
		}

		JTableProgramResponse jsonJtableResponse;
		
		try {
			programService.save(programBean);
			
			jsonJtableResponse = new JTableProgramResponse("OK", programBean);
		} catch (Exception e) {
			LOG.error("Exception while adding program", e);
			jsonJtableResponse = new JTableProgramResponse("ERROR", "Could not complete the operation.");
		}

		return jsonJtableResponse;
	}

	@RequestMapping(value = "/updateProgram", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse updateProgram(@ModelAttribute JTableProgramBean programBean, BindingResult result) {
		if (result.hasErrors()) {
			LOG.error(result.getAllErrors());
			return new JTableProgramResponse("ERROR", "Form invalid");
		}

		JTableProgramResponse jsonJtableResponse;

		try {
			programService.update(programBean);
			jsonJtableResponse = new JTableProgramResponse("OK", programBean);
		} catch (Exception e) {
			LOG.error("Exception while updating program", e);
			jsonJtableResponse = new JTableProgramResponse("ERROR", "Could not complete the operation.");
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
			LOG.error("Exception while deleting program", e);
			jsonJtableResponse = new JTableProgramResponse("ERROR", "Could not complete the operation.");
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
