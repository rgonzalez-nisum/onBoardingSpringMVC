package com.nisum.onboarding.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.model.TaskStatus;
import com.nisum.onboarding.model.hibernate.TaskHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class TaskDaoImpl extends HibernateDaoImpl<TaskHibernate, Long> implements TaskDao<TaskHibernate> {
	
	@Override
	public List<TaskHibernate> findByProgramId(Long programId) {
		return getSession().getNamedQuery(getEntityName() + ".findByProgramId")
				.setParameter("programId", programId)
				.list();
	}

	@Override
	public List<TaskHibernate> findByStatus(TaskStatus status) {
		return getSession().getNamedQuery(getEntityName() + ".findByStatus")
				.setParameter("status", status)
				.list();
	}
	
}
