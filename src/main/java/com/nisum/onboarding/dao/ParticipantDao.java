package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.dto.ParticipantDto;

public interface ParticipantDao extends GenericDao<ParticipantDto, Long> {

	public ParticipantDto findByEmail(String email);
	
	public List<ParticipantDto> findByNameOrLastname(String nameOrLastname);
	
}
