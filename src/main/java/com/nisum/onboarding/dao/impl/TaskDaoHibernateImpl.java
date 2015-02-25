package com.nisum.onboarding.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.AbstractHibernateDao;
import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.dto.TaskDto;
import com.nisum.onboarding.model.TaskStatus;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;
import com.nisum.onboarding.model.hibernate.TaskHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class TaskDaoHibernateImpl extends AbstractHibernateDao<TaskDto, Long> implements TaskDao {
	
	private static final Logger LOG = Logger.getLogger(TaskDaoHibernateImpl.class);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public TaskDaoHibernateImpl() {
		super(TaskHibernate.class);
	}

	@Override
	public List<TaskDto> findByProgramId(Long programId) {
		List<Serializable> results = getSession().getNamedQuery(getEntityName() + ".findByProgramId")
				.setParameter("programId", programId)
				.list();
		
		return persistentsToDtos(results);
	}

	@Override
	public List<TaskDto> findByStatus(TaskStatus status) {
		List<Serializable> results = getSession().getNamedQuery(getEntityName() + ".findByStatus")
				.setParameter("status", status)
				.list();
		
		return persistentsToDtos(results);
	}

	@Override
	protected Serializable dtoToPersistent(TaskDto taskDto) {
		if (taskDto == null)
			return null;
		
		ProgramHibernate program = new ProgramHibernate();
		program.setId(taskDto.getProgram());

		TaskHibernate task = new TaskHibernate();
		task.setId(taskDto.getId());
		task.setProgram(program);
		task.setContent(taskDto.getContent());
		task.setTaskDay(taskDto.getTaskDay());
		task.setStarted(parseDate(taskDto.getStarted()));
		task.setEnded(parseDate(taskDto.getEnded()));
		task.setStatus(taskDto.getStatus());
		task.setComment(taskDto.getComment());
		task.setReview(taskDto.getReview());
		
		return task;
	}

	@Override
	protected TaskDto persistentToDto(Serializable persistent) {
		if (persistent == null || !(persistent instanceof TaskHibernate))
			return null;
		
		TaskHibernate task = (TaskHibernate) persistent;
		
		TaskDto taskDto = new TaskDto();
		taskDto.setId(task.getId());
		taskDto.setProgram(task.getProgram().getId());
		taskDto.setContent(task.getContent());
		taskDto.setTaskDay(task.getTaskDay());
		taskDto.setStarted(formatDate(task.getStarted()));
		taskDto.setEnded(formatDate(task.getEnded()));
		taskDto.setComment(task.getComment());
		taskDto.setReview(task.getReview());
		
		return taskDto;
	}
	
	private Date parseDate(String stringDate) {
		if (stringDate == null || stringDate.trim().isEmpty())
			return null;
		
		Date date = null;
		try {
			date = DATE_FORMAT.parse(stringDate);
		} catch(ParseException e) {
			LOG.error("Exception parsing Task started/ended date", e);
		}
		
		return date;
	}
	
	private String formatDate(Date date) {
		return date == null ? null : DATE_FORMAT.format(date);
	}
	
}
