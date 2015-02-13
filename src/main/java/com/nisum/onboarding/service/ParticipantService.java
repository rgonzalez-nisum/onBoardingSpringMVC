package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.exception.ParticipantException;
import com.nisum.onboarding.model.Participant;

public interface ParticipantService {

	public void save(Participant participant) throws ParticipantException;
	
	public void update(Participant participant) throws ParticipantException;
	
	public void delete(Participant participant) throws ParticipantException;
	
	public List<Participant> findAll() throws ParticipantException;
	
	public Participant findById(Long id) throws ParticipantException;
	
}
