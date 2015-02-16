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

import com.nisum.onboarding.dto.bean.JsonJTableOptionBean;
import com.nisum.onboarding.dto.bean.JsonJTableParticipantBean;
import com.nisum.onboarding.dto.response.JsonJTableOptionListResponse;
import com.nisum.onboarding.dto.response.JsonJTableParticipantListResponse;
import com.nisum.onboarding.dto.response.JsonJTableParticipantResponse;
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
	public JsonJTableParticipantListResponse getAllParticipants(String jtSorting) {
		JsonJTableParticipantListResponse response;

		try {
			List<JsonJTableParticipantBean> participants = participantToJsonJTableParticipantBean(participantService
					.findAll());
			response = new JsonJTableParticipantListResponse("OK", participants,
					participants.size());
		} catch (Exception e) {
			response = new JsonJTableParticipantListResponse("ERROR", e.getMessage());
		}

		return response;
	}

	@RequestMapping(value = "/positions", method = RequestMethod.POST)
	public @ResponseBody JsonJTableOptionListResponse getPositions() {
		List<JsonJTableOptionBean> positions = allPositions();
		return new JsonJTableOptionListResponse("OK", positions);
	}

	@RequestMapping(value = "/addParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JsonJTableParticipantResponse addParticipant(@ModelAttribute JsonJTableParticipantBean participantBean, BindingResult result) {
		JsonJTableParticipantResponse jsonJtableResponse;
		if (result.hasErrors()) {
			jsonJtableResponse = new JsonJTableParticipantResponse("ERROR", "Form invalid");
		}

		Participant participant = jsonJTableParticipantBeanToParticipant(participantBean);

		try {
			participantService.save(participant);
			jsonJtableResponse = new JsonJTableParticipantResponse("OK", participant);
		} catch (Exception e) {
			jsonJtableResponse = new JsonJTableParticipantResponse("ERROR", e.getMessage());
		}

		return jsonJtableResponse;
	}

	@RequestMapping(value = "/updateParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JsonJTableParticipantResponse updateParticipant(@ModelAttribute JsonJTableParticipantBean participantBean, BindingResult result) {
		JsonJTableParticipantResponse jsonJtableResponse;
		if (result.hasErrors()) {
			jsonJtableResponse = new JsonJTableParticipantResponse("ERROR", "Form invalid");
		}

		Participant participant = jsonJTableParticipantBeanToParticipant(participantBean);

		try {
			participantService.update(participant);
			jsonJtableResponse = new JsonJTableParticipantResponse("OK", participant);
		} catch (Exception e) {
			jsonJtableResponse = new JsonJTableParticipantResponse("ERROR", e.getMessage());
		}
		return jsonJtableResponse;
	}

	@RequestMapping(value = "/deleteParticipant", method = RequestMethod.POST)
	@ResponseBody
	public JsonJTableParticipantResponse deleteParticipant(@RequestParam Long id) {
		JsonJTableParticipantResponse jsonJtableResponse;
		
		try {
			participantService.deleteById(id);
			jsonJtableResponse = new JsonJTableParticipantResponse("OK");
		} catch (Exception e) {
			jsonJtableResponse = new JsonJTableParticipantResponse("ERROR", e.getMessage());
		}
		return jsonJtableResponse;
	}

	private List<JsonJTableOptionBean> allPositions() {
		List<JsonJTableOptionBean> positions = new ArrayList<JsonJTableOptionBean>();
		positions.add(new JsonJTableOptionBean("Intership"));
		positions.add(new JsonJTableOptionBean("Developer Trainee"));
		positions.add(new JsonJTableOptionBean("Developer Junior"));
		positions.add(new JsonJTableOptionBean("Developer Senior"));
		positions.add(new JsonJTableOptionBean("QA Trainee"));
		positions.add(new JsonJTableOptionBean("QA Junior"));
		positions.add(new JsonJTableOptionBean("QA Senior"));

		return positions;
	}

	private List<JsonJTableParticipantBean> participantToJsonJTableParticipantBean(
			List<Participant> participants) {
		List<JsonJTableParticipantBean> participantsBeans = new ArrayList<JsonJTableParticipantBean>();

		for (Participant participant : participants) {
			JsonJTableParticipantBean participantsBean = new JsonJTableParticipantBean();
			participantsBean.setId(participant.getId());
			participantsBean.setName(participant.getName());
			participantsBean.setLastname(participant.getLastname());
			participantsBean.setPosition(participant.getPosition());
			participantsBean.setEmail(participant.getEmail());

			participantsBeans.add(participantsBean);
		}

		return participantsBeans;
	}

	private Participant jsonJTableParticipantBeanToParticipant(JsonJTableParticipantBean bean) {
		return new Participant(bean.getId(), bean.getName(), bean.getLastname(),
				bean.getPosition(), bean.getEmail());
	}

}
