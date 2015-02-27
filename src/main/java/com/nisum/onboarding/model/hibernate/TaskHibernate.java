package com.nisum.onboarding.model.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;

@NamedQueries({
	@NamedQuery(name = "Task.findAll", query = "from Task order by program.id, taskDay"),
	@NamedQuery(name = "Task.findByProgramId", query = "from Task where program.id = :programId order by taskDay"),
	@NamedQuery(name = "Task.findByStatus", query = "from Task where status = :status order by program.id, taskDay") 
})
@Entity(name = "Task")
@Table(name = "task")
public class TaskHibernate implements Task {

	@Transient
	private static final long serialVersionUID = 797684742710974944L;

	@Id
	@SequenceGenerator(name = "gen_task_id", sequenceName = "seq_task_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_task_id")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id", nullable = false)
	private ProgramHibernate program;

	@Column(name = "content")
	private String content;

	@Column(name = "task_day")
	private String taskDay;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "started", length = 29)
	private Date started;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ended", length = 29)
	private Date ended;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 15)
	private TaskStatus status;

	@Column(name = "comment")
	private String comment;

	@Column(name = "review")
	private String review;

	public TaskHibernate() {
	}
	
	public TaskHibernate(Long id, ProgramHibernate program, String content, String taskDay, Date started,
			Date ended, TaskStatus status, String comment, String review) {
		setId(id);
		setProgram(program);
		setContent(content);
		setTaskDay(taskDay);
		setStarted(started);
		setEnded(ended);
		setStatus(status);
		setComment(comment);
		setReview(review);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public ProgramHibernate getProgram() {
		return program;
	}

	@Override
	public void setProgram(Program program) {
		this.program = (ProgramHibernate) program;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String getTaskDay() {
		return taskDay;
	}

	@Override
	public void setTaskDay(String taskDay) {
		this.taskDay = taskDay;
	}

	@Override
	public Date getStarted() {
		return started;
	}

	@Override
	public void setStarted(Date started) {
		this.started = started;
	}

	@Override
	public Date getEnded() {
		return ended;
	}

	@Override
	public void setEnded(Date ended) {
		this.ended = ended;
	}

	@Override
	public TaskStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String getReview() {
		return review;
	}

	@Override
	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", program=" + program + ", content=" + content + ", taskDay="
				+ taskDay + ", started=" + started + ", ended=" + ended + ", status=" + status
				+ ", comment=" + comment + ", review=" + review + "]";
	}
	
}
