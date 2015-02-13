package com.nisum.onboarding.model;

import java.sql.Timestamp;
import java.util.Set;

public class Program {

	private Long id;
	private Participant participant;
	private String description;
	private String status;
	private Timestamp started;
	private Set<ProgramTask> programTasks;

	public Program() {
	}

	public Program(Long id, Participant participant, String description, String status,
			Timestamp started) {
		setId(id);
		setParticipant(participant);
		setDescription(description);
		setStatus(status);
		setStarted(started);
	}
	
	public Program(Long id, Participant participant, String description, String status,
			Timestamp started, Set<ProgramTask> programTasks) {
		setId(id);
		setParticipant(participant);
		setDescription(description);
		setStatus(status);
		setStarted(started);
		setProgramTasks(programTasks);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getStarted() {
		return started;
	}

	public void setStarted(Timestamp started) {
		this.started = started;
	}

	public Set<ProgramTask> getProgramTasks() {
		return programTasks;
	}

	public void setProgramTasks(Set<ProgramTask> programTasks) {
		this.programTasks = programTasks;
	}
	
}
