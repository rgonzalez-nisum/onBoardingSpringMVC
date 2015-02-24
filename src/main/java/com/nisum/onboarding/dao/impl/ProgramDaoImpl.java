package com.nisum.onboarding.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ProgramDaoImpl extends HibernateDaoImpl<ProgramHibernate, Long> implements ProgramDao<ProgramHibernate> {

	@Override
	public List<ProgramHibernate> findByParticipantId(Long participantId) {
		return getSession().getNamedQuery(getEntityName() + ".findByParticipantId")
				.setParameter("participantId", participantId)
				.list();
	}

	@Override
	public List<ProgramHibernate> findByStatus(ProgramStatus status) {
		return getSession().getNamedQuery(getEntityName() + ".findByStatus")
				.setParameter("status", status)
				.list();
	}
	

}
