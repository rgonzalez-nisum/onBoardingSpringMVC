package com.nisum.onboarding.model;

import java.sql.Timestamp;

public class ProgramTask {

	private Long id;
	private Program program;
	private String content;
	private Integer taskDay;
	private Timestamp started;
	private Timestamp ended;
	private String status;
	private String comment;
	private String review;

	public ProgramTask(Long id, Program program, String content, Integer taskDay,
			Timestamp started, Timestamp ended, String status, String comment, String review) {
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

	public Timestamp getStarted() {
		return started;
	}

	public void setStarted(Timestamp started) {
		this.started = started;
	}

	public Timestamp getEnded() {
		return ended;
	}

	public void setEnded(Timestamp ended) {
		this.ended = ended;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

}
