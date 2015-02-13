package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.Participant;

public interface ParticipantService extends GenericService<Participant, Long> {

	public Participant findByEmail(String email) throws BeanException;
	
	public List<Participant> findByNameOrLastname(String nameOrLastname) throws BeanException;
	
}
