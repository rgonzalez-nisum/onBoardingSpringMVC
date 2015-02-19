package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.bean.JTableTaskBean;
import com.nisum.onboarding.model.TaskStatus;

public interface TaskService extends GenericService<JTableTaskBean, Long> {
	
	public TaskDao getTaskDao();
	
	public void setTaskDao(TaskDao taskDao);
	
	public List<JTableTaskBean> findByProgramId(Long programId) throws BeanException;
	
	public List<JTableTaskBean> findByStatus(TaskStatus status) throws BeanException;

}
