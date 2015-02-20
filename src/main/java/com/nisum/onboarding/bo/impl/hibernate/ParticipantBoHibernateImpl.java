package com.nisum.onboarding.bo.impl.hibernate;

import java.util.HashSet;
import java.util.Set;

import com.nisum.onboarding.bo.ProgramBo;
import com.nisum.onboarding.bo.impl.ParticipantBoImpl;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.hibernate.ParticipantHibernate;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ParticipantBoHibernateImpl extends ParticipantBoImpl<ParticipantHibernate> {

	private static final long serialVersionUID = 383833453667054448L;

	public ParticipantBoHibernateImpl() {
	}

	public ParticipantBoHibernateImpl(ParticipantHibernate participant) {
		super(participant);
	}

	@Override
	protected Set<ProgramBoHibernateImpl> toProgramBos(Set<? extends Program> programs) {
		if (programs == null || programs.isEmpty())
			return new HashSet<ProgramBoHibernateImpl>(0);

		Set<ProgramBoHibernateImpl> programBos = new HashSet<ProgramBoHibernateImpl>(programs.size());
		for (Program program : programs) {
			programBos.add(new ProgramBoHibernateImpl((ProgramHibernate) program));
		}

		return programBos;
	}

	@Override
	protected Set<ProgramHibernate> toPrograms(Set<? extends ProgramBo> jtablePrograms) throws Exception {
		if (jtablePrograms == null || jtablePrograms.isEmpty())
			return new HashSet<ProgramHibernate>(0);

		Set<ProgramHibernate> programs = new HashSet<ProgramHibernate>(jtablePrograms.size());
		for (ProgramBo<ProgramHibernate> jtableProgram : jtablePrograms) {
			programs.add(jtableProgram.toProgram());
		}

		return programs;
	}

}
