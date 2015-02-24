package com.nisum.onboarding.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.model.hibernate.ParticipantHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ParticipantDaoImpl extends HibernateDaoImpl<ParticipantHibernate, Long> implements ParticipantDao<ParticipantHibernate> {

	@Override
	public ParticipantHibernate findByEmail(String email) {
		List<?> results = getSession().getNamedQuery(getEntityName() + ".findByEmail")
				.setParameter("email", email)
				.list();

		return !results.isEmpty() ? (ParticipantHibernate) results.get(0) : null;
	}

	@Override
	public List<ParticipantHibernate> findByNameOrLastname(String nameOrLastname) {
		return getSession().getNamedQuery(getEntityName() + ".findByNameOrLastname")
				.setParameter("name", nameOrLastname)
				.setParameter("lastname", nameOrLastname)
				.list();
	}

}
