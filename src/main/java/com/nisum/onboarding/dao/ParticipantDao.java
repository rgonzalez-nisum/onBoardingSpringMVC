package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.model.Participant;

public interface ParticipantDao extends GenericDao<Participant, Long> {

	public Participant findByEmail(String email);
	
	public List<Participant> findByNameOrLastname(String nameOrLastname);
	
}
