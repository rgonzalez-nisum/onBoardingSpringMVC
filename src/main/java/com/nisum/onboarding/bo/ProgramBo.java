package com.nisum.onboarding.bo;

import java.util.List;

import com.nisum.onboarding.dto.ProgramDto;
import com.nisum.onboarding.model.ProgramStatus;

public interface ProgramBo extends GenericBo<ProgramDto, Long> {
	
	public List<ProgramDto> findByParticipantId(Long participantId);
	
	public List<ProgramDto> findByStatus(ProgramStatus status);

}
