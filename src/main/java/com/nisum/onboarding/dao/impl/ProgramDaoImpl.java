package com.nisum.onboarding.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ProgramDaoImpl extends HibernateDaoImpl<Program, Long> implements ProgramDao {

	@Override
	public List<Program> findByParticipantId(Long participantId) {
		return getSession().getNamedQuery("Program.findByParticipantId")
				.setParameter("participantId", participantId)
				.list();
	}

	@Override
	public List<Program> findByStatus(ProgramStatus status) {
		return getSession().getNamedQuery("Program.findByStatus")
				.setParameter("status", status)
				.list();
	}

}
