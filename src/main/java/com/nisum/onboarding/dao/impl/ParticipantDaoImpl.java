package com.nisum.onboarding.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.model.hibernate.ParticipantHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ParticipantDaoImpl extends HibernateDaoImpl<Participant, Long> implements ParticipantDao {

	@Override
	public Participant findByEmail(String email) {
		List<?> results = getSession().getNamedQuery("Participant.findByEmail")
				.setParameter("email", email)
				.list();

		return !results.isEmpty() ? (ParticipantHibernate) results.get(0) : null;
	}

	@Override
	public List<Participant> findByNameOrLastname(String nameOrLastname) {
		return getSession().getNamedQuery("Participant.findByNameOrLastname")
				.setParameter("name", nameOrLastname)
				.setParameter("lastname", nameOrLastname)
				.list();
	}

}
