package com.nisum.onboarding.dto;

import com.nisum.onboarding.model.TaskStatus;


public class TaskDto implements SerializableDto {

	private static final long serialVersionUID = -3778099422420706640L;

	private Long id;
	private Long program;
	private String content;
	private Integer taskDay;
	private String started;
	private String ended;
	private TaskStatus status;
	private String comment;
	private String review;

	public TaskDto() {
	}

	public TaskDto(Long id, Long program, String content, Integer taskDay, String started,
			String ended, TaskStatus status, String comment, String review) {
		this.id = id;
		this.program = program;
		this.content = content;
		this.taskDay = taskDay;
		this.started = started;
		this.ended = ended;
		this.status = status;
		this.comment = comment;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProgram() {
		return program;
	}

	public void setProgram(Long program) {
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

	public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public String getEnded() {
		return ended;
	}

	public void setEnded(String ended) {
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

}
