package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.bean.JTableProgramBean;
import com.nisum.onboarding.model.ProgramStatus;

public interface ProgramService extends GenericService<JTableProgramBean, Long> {

	public ProgramDao getProgramDao();
	
	public void setProgramDao(ProgramDao programDao);
	
	public List<JTableProgramBean> findByParticipantId(Long participantId) throws BeanException;
	
	public List<JTableProgramBean> findByStatus(ProgramStatus status) throws BeanException;
	
}
