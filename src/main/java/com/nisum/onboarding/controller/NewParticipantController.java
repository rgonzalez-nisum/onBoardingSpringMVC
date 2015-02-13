package com.nisum.onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nisum.onboarding.dao.ParticipantDao;

@Controller
@RequestMapping("/participants")
public class NewParticipantController {

	@Autowired
	private ParticipantDao participantDao;
	
}
