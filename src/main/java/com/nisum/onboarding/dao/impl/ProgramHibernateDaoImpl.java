package com.nisum.onboarding.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.AbstractHibernateDao;
import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.dto.ProgramDto;
import com.nisum.onboarding.dto.TaskDto;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.hibernate.ParticipantHibernate;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;
import com.nisum.onboarding.model.hibernate.TaskHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ProgramHibernateDaoImpl extends AbstractHibernateDao<ProgramDto, Long> implements ProgramDao {

	private static final Logger LOG = Logger.getLogger(ProgramHibernateDaoImpl.class);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public ProgramHibernateDaoImpl() {
		super(ProgramHibernate.class);
	}

	@Override
	public List<ProgramDto> findByParticipantId(Long participantId) {
		List<Serializable> results = getSession().getNamedQuery(getEntityName() + ".findByParticipantId")
				.setParameter("participantId", participantId)
				.list();
		
		return persistentsToDtos(results);
	}

	@Override
	public List<ProgramDto> findByStatus(ProgramStatus status) {
		List<Serializable> results = getSession().getNamedQuery(getEntityName() + ".findByStatus")
				.setParameter("status", status)
				.list();
		
		return persistentsToDtos(results);
	}

	@Override
	protected Serializable dtoToPersistent(ProgramDto programDto) {
		if (programDto == null)
			return null;
		
		ParticipantHibernate participant = new ParticipantHibernate();
		participant.setId(programDto.getParticipant());
		
		ProgramHibernate program = new ProgramHibernate();
		program.setId(programDto.getId());
		program.setParticipant(participant);
		program.setDescription(programDto.getDescription());
		program.setStatus(programDto.getStatus());
		program.setStarted(parseDate(programDto.getStarted()));
		program.setTasks(toTasks(programDto.getTasks()));
		
		return program;
	}

	@Override
	protected ProgramDto persistentToDto(Serializable persistent) {
		if (persistent == null || !(persistent instanceof ProgramHibernate))
			return null;
		
		ProgramHibernate program = (ProgramHibernate) persistent;
		ProgramDto programDto = new ProgramDto();
		programDto.setId(program.getId());
		programDto.setParticipant(program.getParticipant().getId());
		programDto.setDescription(program.getDescription());
		programDto.setStatus(program.getStatus());
		programDto.setStarted(formatDate(program.getStarted()));
		programDto.setTasks(toTaskDtos(program.getTasks()));
		
		return programDto;
	}
	
	private Set<TaskDto> toTaskDtos(Set<TaskHibernate> tasks) {
		if (tasks == null || tasks.isEmpty())
			return new HashSet<TaskDto>(0);

		Set<TaskDto> taskDtos = new HashSet<TaskDto>(tasks.size());
		for (Task task : tasks) {
			TaskDto taskDto = new TaskDto();
			taskDto.setId(task.getId());
			taskDto.setProgram(task.getProgram().getId());
			taskDto.setContent(task.getContent());
			taskDto.setTaskDay(task.getTaskDay());
			taskDto.setStarted(formatDate(task.getStarted()));
			taskDto.setEnded(formatDate(task.getEnded()));
			taskDto.setComment(task.getComment());
			taskDto.setReview(task.getReview());
			
			taskDtos.add(taskDto);
		}

		return taskDtos;
	}

	private Set<TaskHibernate> toTasks(Set<TaskDto> taskDtos) {
		if (taskDtos == null || taskDtos.isEmpty())
			return new HashSet<TaskHibernate>(0);

		Set<TaskHibernate> tasks = new HashSet<TaskHibernate>(taskDtos.size());
		for (TaskDto taskDto : taskDtos) {
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
			
			tasks.add(task);
		}

		return tasks;
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
