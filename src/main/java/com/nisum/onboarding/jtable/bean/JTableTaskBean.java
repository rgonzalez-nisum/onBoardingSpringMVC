package com.nisum.onboarding.jtable.bean;

import java.text.SimpleDateFormat;

import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;

public class JTableTaskBean {
	
	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private Long id;
	private Long program;
	private String content;
	private Integer taskDay;
	private String started;
	private String ended;
	private TaskStatus status;
	private String comment;
	private String review;
	
	public JTableTaskBean() {
	}
	
	public JTableTaskBean(Task task) {
		setId(task.getId());
		setProgram(task.getProgram().getId());
		setContent(task.getContent());
		setTaskDay(task.getTaskDay());
		setStarted(DATE_FORMAT.format(task.getStarted()));
		setEnded(DATE_FORMAT.format(task.getEnded()));
		setComment(task.getComment());
		setReview(task.getReview());
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

	public Task toTask() throws Exception {
		Program selectedProgram = new Program();
		selectedProgram.setId(program);

		Task task = new Task();
		task.setId(id);
		task.setProgram(selectedProgram);
		task.setContent(content);
		task.setTaskDay(taskDay);
		task.setStarted(DATE_FORMAT.parse(started));
		task.setEnded(DATE_FORMAT.parse(ended));
		task.setComment(comment);
		task.setReview(review);
		
		return task;
	}

}
