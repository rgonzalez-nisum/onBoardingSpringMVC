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

import com.nisum.onboarding.bo.impl.OptionBoImpl;
import com.nisum.onboarding.bo.impl.ProgramBo;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;
import com.nisum.onboarding.jtable.response.impl.JTableProgramListResponse;
import com.nisum.onboarding.jtable.response.impl.JTableProgramResponse;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.service.ParticipantService;
import com.nisum.onboarding.service.ProgramService;

@SuppressWarnings({"rawtypes", "unchecked"})
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
			List<ProgramBo> programBeans = programService.findAll();
			
			response = new JTableProgramListResponse("OK", programBeans, programBeans.size());
		} catch (Exception e) {
			LOG.error("Exception while finding all programs", e);
			response = new JTableProgramListResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}
	
	@RequestMapping(value = "/getProgramById", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse getProgramById(@RequestParam(required=true) Long id) {
		JTableProgramResponse response;

		try {
			ProgramBo programBean = programService.findById(id);
			
			response = new JTableProgramResponse("OK", programBean);
		} catch (Exception e) {
			LOG.error("Exception while finding programs by ID", e);
			response = new JTableProgramResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}
	
	@RequestMapping(value = "/getProgramByParticipantId", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramListResponse getProgramByParticipantId(@RequestParam(required=true) Long participantId) {
		JTableProgramListResponse response;

		try {
			List<ProgramBo> programBeans = programService.findByParticipantId(participantId);
			
			response = new JTableProgramListResponse("OK", programBeans, programBeans.size());
		} catch (Exception e) {
			LOG.error("Exception while finding programs by participant ID", e);
			response = new JTableProgramListResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}

	@RequestMapping(value = "/participants", method = RequestMethod.POST)
	public @ResponseBody JTableOptionListResponseImpl getParticipants() throws BeanException {
		List<OptionBoImpl> options = participantService.findAllAsOptions();
		return new JTableOptionListResponseImpl("OK", options);
	}
	
	@RequestMapping(value = "/statuses", method = RequestMethod.POST)
	public @ResponseBody JTableOptionListResponseImpl getPositions() {
		List<OptionBoImpl> statuses = allStatuses();
		return new JTableOptionListResponseImpl("OK", statuses);
	}
	
	@RequestMapping(value = "/addProgram", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse addProgram(@ModelAttribute ProgramBo programBean, BindingResult result) {
		if (result.hasErrors()) {
			LOG.error(result.getAllErrors());
			return new JTableProgramResponse("ERROR", "Form invalid");
		}

		JTableProgramResponse response;
		
		try {
			programService.save(programBean);
			
			response = new JTableProgramResponse("OK", programBean);
		} catch (Exception e) {
			LOG.error("Exception while adding program", e);
			response = new JTableProgramResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}

	@RequestMapping(value = "/updateProgram", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse updateProgram(@ModelAttribute ProgramBo programBean, BindingResult result) {
		if (result.hasErrors()) {
			LOG.error(result.getAllErrors());
			return new JTableProgramResponse("ERROR", "Form invalid");
		}

		JTableProgramResponse response;

		try {
			programService.update(programBean);
			response = new JTableProgramResponse("OK", programBean);
		} catch (Exception e) {
			LOG.error("Exception while updating program", e);
			response = new JTableProgramResponse("ERROR", "Could not complete the operation.");
		}
		
		return response;
	}

	@RequestMapping(value = "/deleteProgram", method = RequestMethod.POST)
	@ResponseBody
	public JTableProgramResponse deleteProgram(@RequestParam(required=true) Long id) {
		JTableProgramResponse response;
		
		try {
			programService.deleteById(id);
			response = new JTableProgramResponse("OK");
		} catch (Exception e) {
			LOG.error("Exception while deleting program", e);
			response = new JTableProgramResponse("ERROR", "Could not complete the operation.");
		}
		
		return response;
	}
	
	private List<OptionBoImpl> allStatuses() {
		List<OptionBoImpl> positions = new ArrayList<OptionBoImpl>();
		
		for (ProgramStatus status : ProgramStatus.values()) {
			positions.add(new OptionBoImpl(status.toString()));
		}

		return positions;
	}
	
}
