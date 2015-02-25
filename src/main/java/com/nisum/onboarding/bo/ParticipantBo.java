package com.nisum.onboarding.bo;

import java.util.List;

import com.nisum.onboarding.dto.ParticipantDto;

public interface ParticipantBo extends GenericBo<ParticipantDto, Long> {

	public ParticipantDto findByEmail(String email);
	
	public List<ParticipantDto> findByNameOrLastname(String nameOrLastname);
	
}
