package com.nisum.onboarding.bo;

import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;

public interface ProgramBo<T extends Program> extends SerializableBo {

	public Long getId();

	public void setId(Long id);

	public Long getParticipant();

	public void setParticipant(Long participant);

	public String getDescription();

	public void setDescription(String description);

	public ProgramStatus getStatus();

	public void setStatus(ProgramStatus status);

	public String getStarted();

	public void setStarted(String started);

	public void fromProgram(T program);
	
	public T toProgram() throws Exception;
	
}
