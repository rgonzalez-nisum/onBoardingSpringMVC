package com.nisum.onboarding.dao;

import java.util.List;

import com.nisum.onboarding.dto.TaskDto;
import com.nisum.onboarding.model.TaskStatus;

public interface TaskDao extends GenericDao<TaskDto, Long> {
	
	public List<TaskDto> findByProgramId(Long programId);
	
	public List<TaskDto> findByStatus(TaskStatus status);

}
