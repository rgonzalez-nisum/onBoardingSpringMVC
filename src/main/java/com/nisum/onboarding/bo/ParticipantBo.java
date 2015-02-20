package com.nisum.onboarding.bo;

import java.util.Set;

import com.nisum.onboarding.model.Participant;

@SuppressWarnings("rawtypes")
public interface ParticipantBo<T extends Participant> extends SerializableBo {

	public Long getId();

	public void setId(Long id);

	public String getName();

	public void setName(String name);

	public String getLastname();

	public void setLastname(String lastname);

	public String getPosition();

	public void setPosition(String position);

	public String getEmail();

	public void setEmail(String email);

	public Set<? extends ProgramBo> getPrograms();

	public void setPrograms(Set<? extends ProgramBo> programs);

	public void fromParticipant(T participant);
	
	public T toParticipant() throws Exception;
	
}
