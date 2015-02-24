package com.nisum.onboarding.controller;

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
import com.nisum.onboarding.bo.impl.hibernate.ParticipantBoHibernateImpl;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.response.impl.JTableOptionListResponseImpl;
import com.nisum.onboarding.jtable.response.impl.JTableParticipantListResponse;
import com.nisum.onboarding.jtable.response.impl.JTableParticipantResponse;
import com.nisum.onboarding.service.ParticipantService;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("/participants")
public class ParticipantController {

	private static final Logger LOG = Logger.getLogger(ParticipantController.class);
	
	@Autowired
	private ParticipantService<ParticipantBo> participantService;

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
	
	@RequestMapping(value = "/getAllParticipantsAsOptions", method = RequestMethod.POST)
	@ResponseBody
	public JTableOptionListResponseImpl getAllParticipantsAsOptions() throws BeanException {
		JTableOptionListResponseImpl response;
		
		try {
			List<ParticipantBo> participants = participantService.findAll();
			List<OptionBoImpl> options = participantService.toOptions(participants);
			response = new JTableOptionListResponseImpl("OK", options);
		} catch (Exception e) {
			LOG.error("Exception while finding all participants", e);
			response = new JTableOptionListResponseImpl("ERROR", "Could not complete the operation.");
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

	@RequestMapping(value = "/addParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantResponse addParticipant(@ModelAttribute ParticipantBoHibernateImpl participant, BindingResult result) {
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
	public JTableParticipantResponse updateParticipant(@ModelAttribute ParticipantBoHibernateImpl participant, BindingResult result) {
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

}
