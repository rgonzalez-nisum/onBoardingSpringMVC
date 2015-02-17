package com.nisum.onboarding.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "Program.findAll", query = "from Program"),
	@NamedQuery(name = "Program.findByParticipantId", query = "from Program where participant.id = :participantId"),
	@NamedQuery(name = "Program.findByStatus", query = "from Program where status = :status") 
})
@Entity
@Table(name = "program")
public class Program implements Serializable {

	private static final long serialVersionUID = -1167078184433822851L;

	@Id
	@SequenceGenerator(name = "gen_program_id", sequenceName = "seq_program_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_program_id")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participant_id", nullable = false)
	private Participant participant;

	@Column(name = "description", length = 255)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 15)
	private ProgramStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "started", nullable = false, length = 29)
	private Timestamp started;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "program", orphanRemoval = true)
	@Cascade({ CascadeType.ALL })
	private Set<Task> tasks = new HashSet<Task>();

	public Program() {
	}

	public Program(Long id, Participant participant, String description, ProgramStatus status,
			Timestamp started) {
		setId(id);
		setParticipant(participant);
		setDescription(description);
		setStatus(status);
		setStarted(started);
	}

	public Program(Long id, Participant participant, String description, ProgramStatus status,
			Timestamp started, Set<Task> tasks) {
		setId(id);
		setParticipant(participant);
		setDescription(description);
		setStatus(status);
		setStarted(started);
		setTasks(tasks);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
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

	public Timestamp getStarted() {
		return started;
	}

	public void setStarted(Timestamp started) {
		this.started = started;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", participant=" + participant + ", description="
				+ description + ", status=" + status + ", started=" + started + ", tasks="
				+ tasks + "]";
	}

}
