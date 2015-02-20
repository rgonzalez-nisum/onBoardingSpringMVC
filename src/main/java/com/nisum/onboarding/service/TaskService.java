package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.bo.TaskBo;
import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.TaskStatus;

@SuppressWarnings("rawtypes")
public interface TaskService<T extends TaskBo> extends GenericService<T, Long> {
	
	public TaskDao getTaskDao();
	
	public void setTaskDao(TaskDao taskDao);
	
	public List<T> findByProgramId(Long programId) throws BeanException;
	
	public List<T> findByStatus(TaskStatus status) throws BeanException;

}
