package com.nisum.onboarding.model;

import java.io.Serializable;
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

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

@NamedQueries({
	@NamedQuery(name = "Task.findAll", query = "from Task"),
	@NamedQuery(name = "Task.findByProgramId", query = "from Task where program.id = :programId"),
	@NamedQuery(name = "Task.findByStatus", query = "from Task where status = :status") 
})
@Entity
@Table(name = "task")
public class Task implements Serializable {

	private static final long serialVersionUID = 797684742710974944L;

	@Id
	@SequenceGenerator(name = "gen_task_id", sequenceName = "seq_task_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_task_id")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id", nullable = false)
	private Program program;

	@Column(name = "content")
	private String content;

	@Column(name = "task_day")
	private Integer taskDay;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "started", nullable = false, length = 29)
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

	public Task() {
	}
	
	public Task(Long id, Program program, String content, Integer taskDay, Date started,
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTaskDay() {
		return taskDay;
	}

	public void setTaskDay(Integer taskDay) {
		this.taskDay = taskDay;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReview() {
		return review;
	}

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
