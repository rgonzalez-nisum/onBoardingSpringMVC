package com.nisum.onboarding.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class TaskDaoImpl extends HibernateDaoImpl<Task, Long> implements TaskDao {
	
	@Override
	public List<Task> findByProgramId(Long programId) {
		return getSession().getNamedQuery("Task.findByProgramId")
				.setParameter("programId", programId)
				.list();
	}

	@Override
	public List<Task> findByStatus(TaskStatus status) {
		return getSession().getNamedQuery("Task.findByStatus")
				.setParameter("status", status)
				.list();
	}
	
}
