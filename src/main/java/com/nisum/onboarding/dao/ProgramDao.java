package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.dto.ProgramDto;
import com.nisum.onboarding.model.ProgramStatus;

public interface ProgramDao extends GenericDao<ProgramDto, Long> {
	
	public List<ProgramDto> findByParticipantId(Long participantId);
	
	public List<ProgramDto> findByStatus(ProgramStatus status);

}
