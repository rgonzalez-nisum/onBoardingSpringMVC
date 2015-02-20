package com.nisum.onboarding.bo.impl;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;

import com.nisum.onboarding.bo.ParticipantBo;
import com.nisum.onboarding.bo.ProgramBo;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.model.Program;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class ParticipantBoImpl<T extends Participant> implements ParticipantBo<T> {

	private static final long serialVersionUID = -5720686673223336674L;
	
	private Long id;
	private String name;
	private String lastname;
	private String position;
	private String email;
	private Set<? extends ProgramBo> programs = new HashSet<ProgramBo>(0);
	
	private Class<T> participantClass;
	
	public ParticipantBoImpl() {
	}
	
	public ParticipantBoImpl(T participant) {
		fromParticipant(participant);
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
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getLastname() {
		return lastname;
	}

	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String getPosition() {
		return position;
	}

	@Override
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Set<? extends ProgramBo> getPrograms() {
		return programs;
	}

	@Override
	public void setPrograms(Set<? extends ProgramBo> programs) {
		this.programs = programs;
	}
	
	@Override
	public void fromParticipant(T participant) {
		setId(participant.getId());
		setName(participant.getName());
		setLastname(participant.getLastname());
		setPosition(participant.getPosition());
		setEmail(participant.getEmail());
		setPrograms(toProgramBos(participant.getPrograms()));
	}

	@Override
	public T toParticipant() throws Exception {
		T participant = getNewInstanceParticipant();
		participant.setId(getId());
		participant.setName(getName());
		participant.setLastname(getLastname());
		participant.setPosition(getPosition());
		participant.setEmail(getEmail());
		participant.setPrograms(toPrograms(getPrograms()));
		
		return participant;
	}
	
	protected abstract Set<? extends ProgramBo> toProgramBos(Set<? extends Program> programs);
	
	protected abstract Set<? extends Program> toPrograms(Set<? extends ProgramBo> programBos) throws Exception;
	
	private T getNewInstanceParticipant() throws InstantiationException, IllegalAccessException {
		if (participantClass == null) {
			ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
			participantClass = (Class<T>) pt.getActualTypeArguments()[0];
		}
		
		return participantClass.newInstance();
	}
	
}
