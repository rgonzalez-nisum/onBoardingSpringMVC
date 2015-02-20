package com.nisum.onboarding.bo.impl;

import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;

import com.nisum.onboarding.bo.TaskBo;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;

@SuppressWarnings("unchecked")
public abstract class TaskBoImpl<T extends Task> implements TaskBo<T> {
	
	private static final long serialVersionUID = -5143966118165094146L;
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
	
	private Class<T> taskClass;

	public TaskBoImpl() {
	}

	public TaskBoImpl(T task) {
		fromTask(task);
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
	public Long getProgram() {
		return program;
	}

	@Override
	public void setProgram(Long program) {
		this.program = program;
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
	public Integer getTaskDay() {
		return taskDay;
	}

	@Override
	public void setTaskDay(Integer taskDay) {
		this.taskDay = taskDay;
	}

	@Override
	public String getStarted() {
		return started;
	}

	@Override
	public void setStarted(String started) {
		this.started = started;
	}

	@Override
	public String getEnded() {
		return ended;
	}

	@Override
	public void setEnded(String ended) {
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
	public void fromTask(T task) {
		setId(task.getId());
		setProgram(task.getProgram().getId());
		setContent(task.getContent());
		setTaskDay(task.getTaskDay());
		setStarted(DATE_FORMAT.format(task.getStarted()));
		setEnded(DATE_FORMAT.format(task.getEnded()));
		setComment(task.getComment());
		setReview(task.getReview());
	}

	@Override	
	public T toTask() throws Exception {
		Program selectedProgram = getNewInstanceProgram();
		selectedProgram.setId(program);

		T task = getNewInstanceTask();
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
	
	private T getNewInstanceTask() throws InstantiationException, IllegalAccessException {
		if (taskClass == null) {
			ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
			taskClass = (Class<T>) pt.getActualTypeArguments()[0];
		}
		
		return taskClass.newInstance();
	}

	protected abstract Program getNewInstanceProgram();

}
