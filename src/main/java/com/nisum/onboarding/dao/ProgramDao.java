package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;

public interface ProgramDao extends GenericDao<Program, Long> {
	
	public List<Program> findByParticipantId(Long id);
	
	public List<Program> findByStatus(ProgramStatus status);

}
