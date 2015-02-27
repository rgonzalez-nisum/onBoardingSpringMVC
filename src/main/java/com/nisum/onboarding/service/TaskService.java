package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.bo.TaskBo;
import com.nisum.onboarding.dto.ParticipantTaskReportDto;
import com.nisum.onboarding.dto.TaskDto;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.TaskStatus;

public interface TaskService extends GenericService<TaskDto, Long> {
	
	public TaskBo getTaskBo();
	
	public void setTaskBo(TaskBo taskBo);
	
	public List<TaskDto> findByProgramId(Long programId) throws BeanException;
	
	public List<TaskDto> findByStatus(TaskStatus status) throws BeanException;
	
	public List<ParticipantTaskReportDto> getParticipantsTaskReport() throws BeanException;

}
