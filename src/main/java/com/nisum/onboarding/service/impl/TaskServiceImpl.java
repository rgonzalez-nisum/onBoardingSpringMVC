package com.nisum.onboarding.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.bo.TaskBo;
import com.nisum.onboarding.dto.ParticipantTaskReportDto;
import com.nisum.onboarding.dto.TaskDto;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.TaskStatus;
import com.nisum.onboarding.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger LOG = Logger.getLogger(TaskServiceImpl.class);
	
	@Autowired
	private TaskBo taskBo;

	public TaskServiceImpl() {
	}

	public TaskServiceImpl(TaskBo taskBo) {
		setTaskBo(taskBo);
	}

	@Override
	public TaskBo getTaskBo() {
		return taskBo;
	}

	@Override
	public void setTaskBo(TaskBo taskBo) {
		this.taskBo = taskBo;
	}

	@Override
	@Transactional
	public void save(TaskDto taskDto) throws BeanException {
		try {
			taskBo.save(taskDto);
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + taskDto;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(TaskDto taskDto) throws BeanException {
		try {
			taskBo.update(taskDto);
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + taskDto;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	@Transactional
	public void delete(Long id) throws BeanException {
		try {
			taskBo.delete(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting task ID " + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TaskDto> findAll() throws BeanException {
		try {
			return taskBo.findAll();
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all tasks";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TaskDto findById(Long id) throws BeanException {
		try {
			return taskBo.findById(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TaskDto> findByProgramId(Long programId) throws BeanException {
		try {
			return taskBo.findByProgramId(programId);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by program ID=" + programId;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TaskDto> findByStatus(TaskStatus status) throws BeanException {
		try {
			return taskBo.findByStatus(status);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by status=" + status;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ParticipantTaskReportDto> getParticipantsTaskReport() throws BeanException {
		try {
			return taskBo.getParticipantsTaskReport();
		} catch (Exception e) {
			String message = "An exception has been thrown while retrieving information for Participant Tasks report";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

}
