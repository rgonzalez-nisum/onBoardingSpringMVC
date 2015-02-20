package com.nisum.onboarding.bo.impl;

import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;

import com.nisum.onboarding.bo.ProgramBo;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;

@SuppressWarnings("unchecked")
public abstract class ProgramBoImpl<T extends Program> implements ProgramBo<T> {

	private static final long serialVersionUID = -5772028459610246237L;
	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private Long id;
	private Long participant;
	private String description;
	private ProgramStatus status;
	private String started;
	
	private Class<T> programClass;
	
	public ProgramBoImpl() {
	}
	
	public ProgramBoImpl(T program) {
		fromProgram(program);
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
	public Long getParticipant() {
		return participant;
	}

	@Override
	public void setParticipant(Long participant) {
		this.participant = participant;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public ProgramStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(ProgramStatus status) {
		this.status = status;
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
	public void fromProgram(T program) {
		setId(program.getId());
		setParticipant(program.getParticipant().getId());
		setDescription(program.getDescription());
		setStatus(program.getStatus());
		setStarted(DATE_FORMAT.format(program.getStarted()));
	}

	@Override
	public T toProgram() throws Exception {
		Participant participant = getNewInstanceParticipant();
		participant.setId(this.participant);

		T program = getNewInstanceProgram();
		program.setId(id);
		program.setParticipant(participant);
		program.setDescription(description);
		program.setStatus(status);
		program.setStarted(DATE_FORMAT.parse(started));
		
		return program;
	}
	
	private T getNewInstanceProgram() throws InstantiationException, IllegalAccessException {
		if (programClass == null) {
			ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
			programClass = (Class<T>) pt.getActualTypeArguments()[0];
		}
		
		return programClass.newInstance();
	}
	
	protected abstract Participant getNewInstanceParticipant();

}
