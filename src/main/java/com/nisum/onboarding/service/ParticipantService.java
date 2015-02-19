package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.bean.JTableParticipantBean;

public interface ParticipantService extends GenericService<JTableParticipantBean, Long>, OptionService {

	public ParticipantDao getParticipantDao();
	
	public void setParticipantDao(ParticipantDao participantDao);
	
	public JTableParticipantBean findByEmail(String email) throws BeanException;
	
	public List<JTableParticipantBean> findByNameOrLastname(String nameOrLastname) throws BeanException;
	
}
