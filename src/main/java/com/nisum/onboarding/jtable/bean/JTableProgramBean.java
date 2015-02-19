package com.nisum.onboarding.jtable.bean;

import java.text.SimpleDateFormat;

import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;

public class JTableProgramBean {

	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private Long id;
	private Long participant;
	private String description;
	private ProgramStatus status;
	private String started;
	
	public JTableProgramBean() {
	}
	
	public JTableProgramBean(Program program) {
		setId(program.getId());
		setParticipant(program.getParticipant().getId());
		setDescription(program.getDescription());
		setStatus(program.getStatus());
		setStarted(DATE_FORMAT.format(program.getStarted()));
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

	public Program toProgram() throws Exception {
		Participant selectedParticipant = new Participant();
		selectedParticipant.setId(participant);

		Program program = new Program();
		program.setId(id);
		program.setParticipant(selectedParticipant);
		program.setDescription(description);
		program.setStatus(status);
		program.setStarted(DATE_FORMAT.parse(started));
		
		return program;
	}

}
