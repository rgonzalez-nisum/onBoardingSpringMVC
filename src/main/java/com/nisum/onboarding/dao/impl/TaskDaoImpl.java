package com.nisum.onboarding.dao.impl;

import java.util.List;

import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;

@SuppressWarnings("unchecked")
public class TaskDaoImpl extends GenericDaoImpl<Task, Long> implements TaskDao {
	
	@Override
	public List<Task> findByProgramId(Long id) {
		List<?> results = getHibernateTemplate().findByNamedQueryAndNamedParam(
				"Task.findByProgramId", "programId", id);
		
		return (List<Task>) results;
	}

	@Override
	public List<Task> findByStatus(TaskStatus status) {
		List<?> results = getHibernateTemplate().findByNamedQueryAndNamedParam(
				"Task.findByStatus", "status", status);
		
		return (List<Task>) results;
	}
	
}
