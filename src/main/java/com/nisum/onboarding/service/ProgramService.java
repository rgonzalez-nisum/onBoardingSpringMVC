package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.bo.ProgramBo;
import com.nisum.onboarding.dto.ProgramDto;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.ProgramStatus;

public interface ProgramService extends GenericService<ProgramDto, Long>, Optionable<ProgramDto> {

	public ProgramBo getProgramBo();
	
	public void setProgramBo(ProgramBo programBo);
	
	public List<ProgramDto> findByParticipantId(Long participantId) throws BeanException;
	
	public List<ProgramDto> findByStatus(ProgramStatus status) throws BeanException;
	
}
