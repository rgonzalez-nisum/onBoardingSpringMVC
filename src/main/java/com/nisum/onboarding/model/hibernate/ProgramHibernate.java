package com.nisum.onboarding.model.hibernate;

import java.util.Date;
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
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.model.Task;

@SuppressWarnings("unchecked")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQueries({
	@NamedQuery(name = "Program.findAll", query = "from Program"),
	@NamedQuery(name = "Program.findByParticipantId", query = "from Program where participant.id = :participantId"),
	@NamedQuery(name = "Program.findByStatus", query = "from Program where status = :status") 
})
@Entity(name = "Program")
@Table(name = "program")
public class ProgramHibernate implements Program {

	@Transient
	private static final long serialVersionUID = -1167078184433822851L;

	@Id
	@SequenceGenerator(name = "gen_program_id", sequenceName = "seq_program_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_program_id")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participant_id", nullable = false)
	private ParticipantHibernate participant;

	@Column(name = "description", length = 255)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 15)
	private ProgramStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "started", nullable = false, length = 29)
	private Date started;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "program")
	private Set<TaskHibernate> tasks = new HashSet<TaskHibernate>();

	public ProgramHibernate() {
	}

	public ProgramHibernate(Long id, ParticipantHibernate participant, String description, ProgramStatus status,
			Date started) {
		setId(id);
		setParticipant(participant);
		setDescription(description);
		setStatus(status);
		setStarted(started);
	}

	public ProgramHibernate(Long id, ParticipantHibernate participant, String description, ProgramStatus status,
			Date started, Set<TaskHibernate> tasks) {
		setId(id);
		setParticipant(participant);
		setDescription(description);
		setStatus(status);
		setStarted(started);
		setTasks(tasks);
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
	public ParticipantHibernate getParticipant() {
		return participant;
	}

	@Override
	public void setParticipant(Participant participant) {
		this.participant = (ParticipantHibernate) participant;
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
	public Date getStarted() {
		return started;
	}

	@Override
	public void setStarted(Date started) {
		this.started = started;
	}

	@Override
	public Set<TaskHibernate> getTasks() {
		return tasks;
	}

	@Override
	public void setTasks(Set<? extends Task> tasks) {
		this.tasks = (Set<TaskHibernate>) tasks;
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", participant=" + participant + ", description="
				+ description + ", status=" + status + ", started=" + started + "]";
	}

}
