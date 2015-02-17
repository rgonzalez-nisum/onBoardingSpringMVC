package com.nisum.onboarding.dao.impl;

import java.util.List;

import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;

@SuppressWarnings("unchecked")
public class ProgramDaoImpl extends GenericDaoImpl<Program, Long> implements ProgramDao {
	
	@Override
	public List<Program> findByParticipantId(Long id) {
		List<?> results = getHibernateTemplate().findByNamedQueryAndNamedParam(
				"Program.findByParticipantId", "participantId", id);
		
		return (List<Program>) results;
	}

	@Override
	public List<Program> findByStatus(ProgramStatus status) {
		List<?> results = getHibernateTemplate().findByNamedQueryAndNamedParam(
				"Program.findByStatus", "status", status);
		
		return (List<Program>) results;
	}
	
}
