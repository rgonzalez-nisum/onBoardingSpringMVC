package com.nisum.onboarding.bo.impl.hibernate;

import com.nisum.onboarding.bo.impl.ProgramBoImpl;
import com.nisum.onboarding.model.hibernate.ParticipantHibernate;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;

public class ProgramBoHibernateImpl extends ProgramBoImpl<ProgramHibernate> {

	private static final long serialVersionUID = -4200039741801977162L;

	public ProgramBoHibernateImpl() {
		super();
	}

	public ProgramBoHibernateImpl(ProgramHibernate program) {
		super(program);
	}

	@Override
	protected ParticipantHibernate getNewInstanceParticipant() {
		return new ParticipantHibernate();
	}
	

}
