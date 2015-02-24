package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.bo.ParticipantBo;
import com.nisum.onboarding.bo.impl.OptionBoImpl;
import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.exception.BeanException;

@SuppressWarnings("rawtypes")
public interface ParticipantService<T extends ParticipantBo> extends GenericService<T, Long>, OptionService<OptionBoImpl, T> {

	public ParticipantDao getParticipantDao();
	
	public void setParticipantDao(ParticipantDao participantDao);
	
	public T findByEmail(String email) throws BeanException;
	
	public List<T> findByNameOrLastname(String nameOrLastname) throws BeanException;
	
}
