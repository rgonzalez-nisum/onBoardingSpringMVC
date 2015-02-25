package com.nisum.onboarding.dto;

import java.util.HashSet;
import java.util.Set;

import com.nisum.onboarding.model.ProgramStatus;

public class ProgramDto implements SerializableDto {

	private static final long serialVersionUID = -4956794253451539523L;

	private Long id;
	private Long participant;
	private String description;
	private ProgramStatus status;
	private String started;
	private Set<TaskDto> tasks = new HashSet<TaskDto>(0);

	public ProgramDto() {
	}

	public ProgramDto(Long id, Long participant, String description, ProgramStatus status, String started) {
		this.id = id;
		this.participant = participant;
		this.description = description;
		this.status = status;
		this.started = started;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParticipant() {
		return participant;
	}

	public void setParticipant(Long participant) {
		this.participant = participant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProgramStatus getStatus() {
		return status;
	}

	public void setStatus(ProgramStatus status) {
		this.status = status;
	}

	public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public Set<TaskDto> getTasks() {
		return tasks;
	}

	public void setTasks(Set<TaskDto> tasks) {
		this.tasks = tasks;
	}

}
