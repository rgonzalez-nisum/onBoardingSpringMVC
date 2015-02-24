package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.model.Participant;

public interface ParticipantDao<T extends Participant> extends GenericDao<T, Long> {

	public T findByEmail(String email);
	
	public List<T> findByNameOrLastname(String nameOrLastname);
	
}
