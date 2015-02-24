package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.bo.ProgramBo;
import com.nisum.onboarding.bo.impl.OptionBoImpl;
import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.ProgramStatus;

@SuppressWarnings("rawtypes")
public interface ProgramService<T extends ProgramBo> extends GenericService<T, Long>, OptionService<OptionBoImpl, T> {

	public ProgramDao getProgramDao();
	
	public void setProgramDao(ProgramDao programDao);
	
	public List<T> findByParticipantId(Long participantId) throws BeanException;
	
	public List<T> findByStatus(ProgramStatus status) throws BeanException;
	
}
