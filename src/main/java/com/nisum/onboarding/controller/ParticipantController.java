package com.nisum.onboarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.service.ParticipantService;

//@Controller
//@RequestMapping("/participants")
public class ParticipantController {

//	@Autowired
//	private ParticipantService participantService;
//	
//	@RequestMapping(value="/register", method = RequestMethod.GET)
//	public String registerParticipantPage(ModelMap modelMap) {
//		modelMap.addAttribute("participant", new Participant());
//		modelMap.addAttribute("positions", allPositions());
//		return "participant/new-participant";
//	}
//
//	@RequestMapping(value="/register", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public Participant registerParticipant(@RequestBody Participant participant) throws Exception {
//		participantService.save(participant);
//		return participant;
//	}
//	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public String allParticipantsPage(ModelMap modelMap) {
//		modelMap.addAttribute("participants", allParticipants());
//		return "participant/all-participants";
//	}
//	
//	private List<String> allPositions() {
//		List<String> positions = new ArrayList<String>();
//		positions.add("Intership");
//		positions.add("Developer Trainee");
//		positions.add("Developer Junior");
//		positions.add("Developer Senior");
//		positions.add("QA Trainee");
//		positions.add("QA Junior");
//		positions.add("QA Senior");
//
//		return positions;
//	}
//	
//	private List<Participant> allParticipants() {
//		List<Participant> participants = new ArrayList<Participant>();
//		
//		try {
//			participants = participantService.findAll();
//		} catch (BeanException e) {
//		}
//		
//		return participants;
//	}
	

}
