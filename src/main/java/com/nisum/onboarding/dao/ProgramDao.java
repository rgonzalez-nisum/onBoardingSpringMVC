package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;

public interface ProgramDao<T extends Program> extends GenericDao<T, Long> {
	
	public List<T> findByParticipantId(Long participantId);
	
	public List<T> findByStatus(ProgramStatus status);

}
