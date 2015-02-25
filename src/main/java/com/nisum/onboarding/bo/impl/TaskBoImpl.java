package com.nisum.onboarding.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nisum.onboarding.bo.TaskBo;
import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.dto.TaskDto;
import com.nisum.onboarding.model.TaskStatus;

@Component
public class TaskBoImpl implements TaskBo {

	@Autowired
	private TaskDao taskDao;
	
	@Override
	public void save(TaskDto dto) {
		taskDao.save(dto);
	}

	@Override
	public void update(TaskDto dto) {
		taskDao.update(dto);
	}

	@Override
	public void delete(Long id) {
		taskDao.deleteById(id);
	}

	@Override
	public List<TaskDto> findAll() {
		return taskDao.findAll();
	}

	@Override
	public TaskDto findById(Long id) {
		return taskDao.findById(id);
	}

	@Override
	public List<TaskDto> findByProgramId(Long programId) {
		return taskDao.findByProgramId(programId);
	}

	@Override
	public List<TaskDto> findByStatus(TaskStatus status) {
		return taskDao.findByStatus(status);
	}

}
