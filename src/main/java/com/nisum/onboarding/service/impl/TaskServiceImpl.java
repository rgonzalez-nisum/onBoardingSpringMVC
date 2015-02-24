package com.nisum.onboarding.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.bo.impl.hibernate.TaskBoHibernateImpl;
import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.TaskStatus;
import com.nisum.onboarding.model.hibernate.TaskHibernate;
import com.nisum.onboarding.service.TaskService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class TaskServiceImpl implements TaskService<TaskBoHibernateImpl> {

	private static final Logger LOG = Logger.getLogger(TaskServiceImpl.class);
	
	@Autowired
	private TaskDao<TaskHibernate> taskDao;

	public TaskServiceImpl() {
	}

	public TaskServiceImpl(TaskDao<TaskHibernate> taskDao) {
		this.taskDao = taskDao;
	}

	public TaskDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	@Transactional
	public void save(TaskBoHibernateImpl taskBo) throws BeanException {
		try {
			taskDao.save(taskBo.toTask());
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + taskBo;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(TaskBoHibernateImpl taskBo) throws BeanException {
		try {
			taskDao.update(taskBo.toTask());
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + taskBo;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(TaskBoHibernateImpl taskBo) throws BeanException {
		try {
			taskDao.delete(taskBo.toTask());
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting " + taskBo;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) throws BeanException {
		try {
			taskDao.deleteById(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting task ID " + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TaskBoHibernateImpl> findAll() throws BeanException {
		try {
			return toTaskBoList(taskDao.findAll());
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all tasks";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TaskBoHibernateImpl findById(Long id) throws BeanException {
		try {
			return toTaskBo(taskDao.findById(id));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TaskBoHibernateImpl> findByProgramId(Long programId) throws BeanException {
		try {
			return toTaskBoList(taskDao.findByProgramId(programId));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by program ID=" + programId;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TaskBoHibernateImpl> findByStatus(TaskStatus status) throws BeanException {
		try {
			return toTaskBoList(taskDao.findByStatus(status));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by status=" + status;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	private TaskBoHibernateImpl toTaskBo(TaskHibernate task) {
		return new TaskBoHibernateImpl(task);
	}

	private List<TaskBoHibernateImpl> toTaskBoList(List<TaskHibernate> tasks) {
		List<TaskBoHibernateImpl> taskBeans = new ArrayList<TaskBoHibernateImpl>();
		
		for (TaskHibernate task : tasks) {
			taskBeans.add(toTaskBo(task));
		}
		
		return taskBeans;
	}

}
