package com.nisum.onboarding.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public interface Program extends Serializable {

	public Long getId();

	public void setId(Long id);

	public Participant getParticipant();

	public void setParticipant(Participant participant);

	public String getDescription();

	public void setDescription(String description);

	public ProgramStatus getStatus();

	public void setStatus(ProgramStatus status);

	public Date getStarted();

	public void setStarted(Date started);

	public Set<? extends Task> getTasks();

	public void setTasks(Set<? extends Task> tasks);

}
