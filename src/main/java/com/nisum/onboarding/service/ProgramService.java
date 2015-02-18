package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;

public interface ProgramService extends GenericService<Program, Long> {

	public ProgramDao getProgramDao();
	
	public void setProgramDao(ProgramDao programDao);
	
	public List<Program> findByParticipantId(Long id) throws BeanException;
	
	public List<Program> findByStatus(ProgramStatus status) throws BeanException;
	
}
