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

import com.nisum.onboarding.bo.ParticipantBo;
import com.nisum.onboarding.bo.impl.OptionBoImpl;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;
import com.nisum.onboarding.jtable.response.impl.JTableParticipantListResponse;
import com.nisum.onboarding.jtable.response.impl.JTableParticipantResponse;
import com.nisum.onboarding.service.ParticipantService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Controller
@RequestMapping("/participants")
public class ParticipantController {

	private static final Logger LOG = Logger.getLogger(ParticipantController.class);
	
	@Autowired
	private ParticipantService participantService;

	@RequestMapping(value = "/getAllParticipants", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantListResponse getAllParticipants() {
		JTableParticipantListResponse response;

		try {
			List<ParticipantBo> participants = participantService.findAll();
			response = new JTableParticipantListResponse("OK", participants, participants.size());
		} catch (Exception e) {
			LOG.error("Exception while finding all participants", e);
			response = new JTableParticipantListResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}
	
	@RequestMapping(value = "/getParticipantById", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantResponse getParticipantById(@RequestParam(required=true) Long id) {
		JTableParticipantResponse response;

		try {
			ParticipantBo participantBean = participantService.findById(id);
			
			response = new JTableParticipantResponse("OK", participantBean);
		} catch (Exception e) {
			LOG.error("Exception while finding participants by ID", e);
			response = new JTableParticipantResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}

	@RequestMapping(value = "/positions", method = RequestMethod.POST)
	public @ResponseBody JTableOptionListResponseImpl getPositions() {
		List<OptionBoImpl> positions = allPositions();
		return new JTableOptionListResponseImpl("OK", positions);
	}

	@RequestMapping(value = "/addParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantResponse addParticipant(@ModelAttribute ParticipantBo participant, BindingResult result) {
		if (result.hasErrors()) {
			return new JTableParticipantResponse("ERROR", "Form invalid");
		}

		JTableParticipantResponse response;
		
		try {
			participantService.save(participant);
			response = new JTableParticipantResponse("OK", participant);
		} catch (Exception e) {
			LOG.error("Exception while finding all participants", e);
			response = new JTableParticipantResponse("ERROR", "Could not complete the operation.");
		}

		return response;
	}

	@RequestMapping(value = "/updateParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantResponse updateParticipant(@ModelAttribute ParticipantBo participant, BindingResult result) {
		if (result.hasErrors()) {
			return new JTableParticipantResponse("ERROR", "Form invalid");
		}

		JTableParticipantResponse response;

		try {
			participantService.update(participant);
			response = new JTableParticipantResponse("OK", participant);
		} catch (Exception e) {
			response = new JTableParticipantResponse("ERROR", e.getMessage());
		}
		
		return response;
	}

	@RequestMapping(value = "/deleteParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantResponse deleteParticipant(@RequestParam(required=true) Long id) {
		JTableParticipantResponse response;
		
		try {
			participantService.deleteById(id);
			response = new JTableParticipantResponse("OK");
		} catch (Exception e) {
			response = new JTableParticipantResponse("ERROR", e.getMessage());
		}
		
		return response;
	}

	private List<OptionBoImpl> allPositions() {
		List<OptionBoImpl> positions = new ArrayList<OptionBoImpl>();
		positions.add(new OptionBoImpl("Intership"));
		positions.add(new OptionBoImpl("Developer Trainee"));
		positions.add(new OptionBoImpl("Developer Junior"));
		positions.add(new OptionBoImpl("Developer Senior"));
		positions.add(new OptionBoImpl("QA Trainee"));
		positions.add(new OptionBoImpl("QA Junior"));
		positions.add(new OptionBoImpl("QA Senior"));

		return positions;
	}

}
