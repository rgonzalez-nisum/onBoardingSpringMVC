package com.nisum.onboarding.model;

import java.io.Serializable;
import java.util.Set;

public interface Participant extends Serializable {
	
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

	public Set<? extends Program> getPrograms();

	public void setPrograms(Set<? extends Program> programs);

}
