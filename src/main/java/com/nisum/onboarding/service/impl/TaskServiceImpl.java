package com.nisum.onboarding.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.bean.JTableTaskBean;
import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;
import com.nisum.onboarding.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger LOG = Logger.getLogger(ProgramServiceImpl.class);
	
	@Autowired
	private TaskDao taskDao;

	public TaskServiceImpl() {
	}

	public TaskServiceImpl(TaskDao taskDao) {
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
	public void save(JTableTaskBean jtableTask) throws BeanException {
		try {
			taskDao.save(jtableTask.toTask());
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + jtableTask;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(JTableTaskBean jtableTask) throws BeanException {
		try {
			taskDao.update(jtableTask.toTask());
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + jtableTask;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(JTableTaskBean jtableTask) throws BeanException {
		try {
			taskDao.delete(jtableTask.toTask());
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting " + jtableTask;
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
	public List<JTableTaskBean> findAll() throws BeanException {
		try {
			return toJTableTaskBeans(taskDao.findAll());
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all tasks";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public JTableTaskBean findById(Long id) throws BeanException {
		try {
			return toJTableTaskBean(taskDao.findById(id));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	public List<JTableTaskBean> findByProgramId(Long programId) throws BeanException {
		try {
			return toJTableTaskBeans(taskDao.findByProgramId(programId));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by program ID=" + programId;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	public List<JTableTaskBean> findByStatus(TaskStatus status) throws BeanException {
		try {
			return toJTableTaskBeans(taskDao.findByStatus(status));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding task by status=" + status;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	private JTableTaskBean toJTableTaskBean(Task task) {
		return new JTableTaskBean(task);
	}


	private List<JTableTaskBean> toJTableTaskBeans(List<Task> tasks) {
		List<JTableTaskBean> taskBeans = new ArrayList<JTableTaskBean>();
		
		for (Task task : tasks) {
			taskBeans.add(toJTableTaskBean(task));
		}
		
		return taskBeans;
	}

}
