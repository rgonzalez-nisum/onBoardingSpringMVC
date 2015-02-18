package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.Participant;

public interface ParticipantService extends GenericService<Participant, Long> {

	public ParticipantDao getParticipantDao();
	
	public void setParticipantDao(ParticipantDao participantDao);
	
	public Participant findByEmail(String email) throws BeanException;
	
	public List<Participant> findByNameOrLastname(String nameOrLastname) throws BeanException;
	
}
