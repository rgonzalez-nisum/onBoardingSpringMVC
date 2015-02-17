package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;

public interface TaskDao extends GenericDao<Task, Long> {
	
	public List<Task> findByProgramId(Long id);
	
	public List<Task> findByStatus(TaskStatus status);

}
