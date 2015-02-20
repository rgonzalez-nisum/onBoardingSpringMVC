package com.nisum.onboarding.bo;

import com.nisum.onboarding.model.Task;
import com.nisum.onboarding.model.TaskStatus;

public interface TaskBo<T extends Task> extends SerializableBo {

	public Long getId();

	public void setId(Long id);

	public Long getProgram();

	public void setProgram(Long program);

	public String getContent();

	public void setContent(String content);

	public Integer getTaskDay();

	public void setTaskDay(Integer taskDay);

	public String getStarted();

	public void setStarted(String started);

	public String getEnded();

	public void setEnded(String ended);

	public TaskStatus getStatus();

	public void setStatus(TaskStatus status);

	public String getComment();

	public void setComment(String comment);

	public String getReview();

	public void setReview(String review);

	public void fromTask(T task);
	
	public T toTask() throws Exception;
	
}
