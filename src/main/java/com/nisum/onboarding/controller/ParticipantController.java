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
import com.nisum.onboarding.jtable.response.impl.JTableParticipantListResponse;
import com.nisum.onboarding.jtable.response.impl.JTableParticipantResponse;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.service.ParticipantService;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String show(ModelMap model) {
		return "participant/participants";
	}

	@RequestMapping(value = "/getAllParticipants", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantListResponse getAllParticipants(String jtSorting) {
		JTableParticipantListResponse response;

		try {
			List<Participant> participants = participantService.findAll();
			response = new JTableParticipantListResponse("OK", participants, participants.size());
		} catch (Exception e) {
			response = new JTableParticipantListResponse("ERROR", e.getMessage());
		}

		return response;
	}

	@RequestMapping(value = "/positions", method = RequestMethod.POST)
	public @ResponseBody JTableOptionListResponseImpl getPositions() {
		List<JTableOptionBean> positions = allPositions();
		return new JTableOptionListResponseImpl("OK", positions);
	}

	@RequestMapping(value = "/addParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantResponse addParticipant(@ModelAttribute Participant participant, BindingResult result) {
		if (result.hasErrors()) {
			return new JTableParticipantResponse("ERROR", "Form invalid");
		}

		JTableParticipantResponse jsonJtableResponse;
		
		try {
			participantService.save(participant);
			jsonJtableResponse = new JTableParticipantResponse("OK", participant);
		} catch (Exception e) {
			jsonJtableResponse = new JTableParticipantResponse("ERROR", e.getMessage());
		}

		return jsonJtableResponse;
	}

	@RequestMapping(value = "/updateParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantResponse updateParticipant(@ModelAttribute Participant participant, BindingResult result) {
		if (result.hasErrors()) {
			return new JTableParticipantResponse("ERROR", "Form invalid");
		}

		JTableParticipantResponse jsonJtableResponse;

		try {
			participantService.update(participant);
			jsonJtableResponse = new JTableParticipantResponse("OK", participant);
		} catch (Exception e) {
			jsonJtableResponse = new JTableParticipantResponse("ERROR", e.getMessage());
		}
		
		return jsonJtableResponse;
	}

	@RequestMapping(value = "/deleteParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JTableParticipantResponse deleteParticipant(@RequestParam Long id) {
		JTableParticipantResponse jsonJtableResponse;
		
		try {
			participantService.deleteById(id);
			jsonJtableResponse = new JTableParticipantResponse("OK");
		} catch (Exception e) {
			jsonJtableResponse = new JTableParticipantResponse("ERROR", e.getMessage());
		}
		
		return jsonJtableResponse;
	}

	private List<JTableOptionBean> allPositions() {
		List<JTableOptionBean> positions = new ArrayList<JTableOptionBean>();
		positions.add(new JTableOptionBean("Intership"));
		positions.add(new JTableOptionBean("Developer Trainee"));
		positions.add(new JTableOptionBean("Developer Junior"));
		positions.add(new JTableOptionBean("Developer Senior"));
		positions.add(new JTableOptionBean("QA Trainee"));
		positions.add(new JTableOptionBean("QA Junior"));
		positions.add(new JTableOptionBean("QA Senior"));

		return positions;
	}

}
