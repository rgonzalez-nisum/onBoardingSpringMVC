package com.nisum.onboarding.bo;

import java.util.List;

import com.nisum.onboarding.dto.TaskDto;
import com.nisum.onboarding.model.TaskStatus;

public interface TaskBo extends GenericBo<TaskDto, Long> {
	
	public List<TaskDto> findByProgramId(Long programId);
	
	public List<TaskDto> findByStatus(TaskStatus status);

}
