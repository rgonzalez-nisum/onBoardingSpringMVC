package com.nisum.onboarding.dto;

import java.util.HashSet;
import java.util.Set;

public class ParticipantDto implements SerializableDto {

	private static final long serialVersionUID = -4492840555325968142L;

	private Long id;
	private String name;
	private String lastname;
	private String position;
	private String email;
	private Set<ProgramDto> programs = new HashSet<ProgramDto>(0);

	public ParticipantDto() {
	}

	public ParticipantDto(Long id, String name, String lastname, String position, String email,
			Set<ProgramDto> programs) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.position = position;
		this.email = email;
		this.programs = programs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<ProgramDto> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<ProgramDto> programs) {
		this.programs = programs;
	}

}
