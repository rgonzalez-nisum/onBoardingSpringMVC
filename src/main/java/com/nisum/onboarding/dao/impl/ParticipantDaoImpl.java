package com.nisum.onboarding.dao.impl;

import java.util.List;

import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.model.Participant;

@SuppressWarnings("unchecked")
public class ParticipantDaoImpl extends GenericDaoImpl<Participant, Long> implements ParticipantDao {

	@Override
	public Participant findByEmail(String email) {
		List<?> results = getHibernateTemplate().findByNamedQueryAndNamedParam(
				"Participant.findByEmail", "email", email);

		return !results.isEmpty() ? (Participant) results.get(0) : null;
	}
	
	@Override
	public List<Participant> findByNameOrLastname(String nameOrLastname) {
		String[] paramNames = { "name", "lastname" };
		Object[] values = { nameOrLastname, nameOrLastname };

		List<?> results = getHibernateTemplate().findByNamedQueryAndNamedParam(
				"Participant.findByNameOrLastname", paramNames, values);

		return (List<Participant>) results;
	}

}
