package com.nisum.onboarding.dto;

import java.util.Date;

import com.nisum.onboarding.model.ProgramStatus;

public class ParticipantTaskReportDto implements SerializableDto {

	private static final long serialVersionUID = -731570253379104030L;

	private String participantName;
	private String participantLastname;
	private String programDescription;
	private Date programStarted;
	private ProgramStatus programStatus;
	private Long assignedTasks;
	private Long startedTasks;
	private Long inProgressTasks;
	private Long completedTasks;
	
	public ParticipantTaskReportDto() {
		super();
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getParticipantLastname() {
		return participantLastname;
	}

	public void setParticipantLastname(String participantLastname) {
		this.participantLastname = participantLastname;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	public Date getProgramStarted() {
		return programStarted;
	}

	public void setProgramStarted(Date programStarted) {
		this.programStarted = programStarted;
	}

	public ProgramStatus getProgramStatus() {
		return programStatus;
	}

	public void setProgramStatus(ProgramStatus programStatus) {
		this.programStatus = programStatus;
	}

	public Long getAssignedTasks() {
		return assignedTasks;
	}

	public void setAssignedTasks(Long assignedTasks) {
		this.assignedTasks = assignedTasks;
	}

	public Long getStartedTasks() {
		return startedTasks;
	}

	public void setStartedTasks(Long startedTasks) {
		this.startedTasks = startedTasks;
	}

	public Long getInProgressTasks() {
		return inProgressTasks;
	}

	public void setInProgressTasks(Long inProgressTasks) {
		this.inProgressTasks = inProgressTasks;
	}

	public Long getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(Long completedTasks) {
		this.completedTasks = completedTasks;
	}

}
