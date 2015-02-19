package com.nisum.onboarding.jtable.bean;

import java.util.HashSet;
import java.util.Set;

import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.model.Program;

public class JTableParticipantBean {

	private Long id;
	private String name;
	private String lastname;
	private String position;
	private String email;
	private Set<JTableProgramBean> programs;
	
	public JTableParticipantBean() {
	}
	
	public JTableParticipantBean(Participant participant) {
		setId(participant.getId());
		setName(participant.getName());
		setLastname(participant.getLastname());
		setPosition(participant.getPosition());
		setEmail(participant.getEmail());
		setPrograms(toJTablePrograms(participant.getPrograms()));
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

	public Set<JTableProgramBean> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<JTableProgramBean> programs) {
		this.programs = programs;
	}

	public Participant toParticipant() throws Exception {
		Participant participant = new Participant();
		participant.setId(id);
		participant.setName(name);
		participant.setLastname(lastname);
		participant.setPosition(position);
		participant.setEmail(email);
		participant.setPrograms(toPrograms(programs));
		
		return participant;
	}
	
	private Set<JTableProgramBean> toJTablePrograms(Set<Program> programs) {
		Set<JTableProgramBean> jtablePrograms = new HashSet<JTableProgramBean>();
		
		for (Program program : programs) {
			jtablePrograms.add(new JTableProgramBean(program));
		}
		
		return jtablePrograms;
	}
	
	private Set<Program> toPrograms(Set<JTableProgramBean> jtablePrograms) throws Exception {
		Set<Program> programs = new HashSet<Program>();
		
		for (JTableProgramBean jtableProgram : jtablePrograms) {
			programs.add(jtableProgram.toProgram());
		}
		
		return programs;
	}

}
