package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.bo.ParticipantBo;
import com.nisum.onboarding.dto.ParticipantDto;
import com.nisum.onboarding.exception.BeanException;

public interface ParticipantService extends GenericService<ParticipantDto, Long>, Optionable<ParticipantDto> {

	public ParticipantBo getParticipantBo();
	
	public void setParticipantBo(ParticipantBo participantBo);
	
	public ParticipantDto findByEmail(String email) throws BeanException;
	
	public List<ParticipantDto> findByNameOrLastname(String nameOrLastname) throws BeanException;
	
}
