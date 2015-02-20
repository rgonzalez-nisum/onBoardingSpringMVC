package com.nisum.onboarding.bo.impl.hibernate;

import com.nisum.onboarding.bo.impl.TaskBoImpl;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;
import com.nisum.onboarding.model.hibernate.TaskHibernate;

public class TaskBoHibernateImpl extends TaskBoImpl<TaskHibernate> {
	
	private static final long serialVersionUID = 7651130659722583709L;

	public TaskBoHibernateImpl() {
		super();
	}

	public TaskBoHibernateImpl(TaskHibernate task) {
		super(task);
	}

	@Override
	protected ProgramHibernate getNewInstanceProgram() {
		return new ProgramHibernate();
	}

}
