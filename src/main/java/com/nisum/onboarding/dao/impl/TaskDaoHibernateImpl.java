package com.nisum.onboarding.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.AbstractHibernateDao;
import com.nisum.onboarding.dao.TaskDao;
import com.nisum.onboarding.dto.ParticipantTaskReportDto;
import com.nisum.onboarding.dto.TaskDto;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.model.TaskStatus;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;
import com.nisum.onboarding.model.hibernate.TaskHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class TaskDaoHibernateImpl extends AbstractHibernateDao<TaskDto, Long> implements TaskDao {
	
	private static final Logger LOG = Logger.getLogger(TaskDaoHibernateImpl.class);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final String REPORT_PARTICIPANT_TASK = ""
			+ "SELECT participant.name, participant.lastname, "
				+ "program.description, program.started, program.status, "
				+ "COUNT(assignedTask), COUNT(startedTask), COUNT(inProgressTask), COUNT(completedTask) "
			+ "FROM Participant As participant " 
				+ "INNER JOIN participant.programs AS program "
				+ "LEFT OUTER JOIN program.tasks AS assignedTask WITH (assignedTask.status = :assignedStatus) " 
				+ "LEFT OUTER JOIN program.tasks AS startedTask WITH (startedTask.status = :startedStatus) "
				+ "LEFT OUTER JOIN program.tasks AS inProgressTask WITH (inProgressTask.status = :inProgressStatus) " 
				+ "LEFT OUTER JOIN program.tasks AS completedTask WITH (completedTask.status = :completedStatus) "
			+ "GROUP BY participant, program "
			+ "ORDER BY participant, program ";
	
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
	public List<ParticipantTaskReportDto> getParticipantsTaskReport() {
		List<Object[]> results = getSession().createQuery(REPORT_PARTICIPANT_TASK)
				.setParameter("assignedStatus", TaskStatus.ASSIGNED)
				.setParameter("startedStatus", TaskStatus.STARTED)
				.setParameter("inProgressStatus", TaskStatus.IN_PROGRESS)
				.setParameter("completedStatus", TaskStatus.COMPLETED)
				.list();
		
		List<ParticipantTaskReportDto> reportResults = new ArrayList<ParticipantTaskReportDto>();
		
		for (Object[] result : results) {
			ParticipantTaskReportDto dto = new ParticipantTaskReportDto();
			dto.setParticipantName((String) result[0]);
			dto.setParticipantLastname((String) result[1]);
			dto.setProgramDescription((String) result[2]);
			dto.setProgramStarted((Date) result[3]);
			dto.setProgramStatus((ProgramStatus) result[4]);
			dto.setAssignedTasks((Long) result[5]);
			dto.setStartedTasks((Long) result[6]);
			dto.setInProgressTasks((Long) result[7]);
			dto.setCompletedTasks((Long) result[8]);
			reportResults.add(dto);
		}
		
		return reportResults;
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
