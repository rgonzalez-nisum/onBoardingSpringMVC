package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;

public interface TaskDao<T extends Task> extends GenericDao<T, Long> {
	
	public List<T> findByProgramId(Long programId);
	
	public List<T> findByStatus(TaskStatus status);

}
