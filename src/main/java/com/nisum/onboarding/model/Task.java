package com.nisum.onboarding.model;

import java.io.Serializable;
import java.util.Date;

public interface Task extends Serializable {

	public Long getId();

	public void setId(Long id);

	public <T extends Program> T getProgram();

	public <T extends Program> void setProgram(T program);

	public String getContent();

	public void setContent(String content);

	public Integer getTaskDay();

	public void setTaskDay(Integer taskDay);

	public Date getStarted();

	public void setStarted(Date started);

	public Date getEnded();

	public void setEnded(Date ended);

	public TaskStatus getStatus();

	public void setStatus(TaskStatus status);

	public String getComment();

	public void setComment(String comment);

	public String getReview();

	public void setReview(String review);

}
