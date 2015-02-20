package com.nisum.onboarding.model.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.model.Program;

@SuppressWarnings("unchecked")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQueries({
		@NamedQuery(name = "Participant.findAll", query = "from Participant"),
		@NamedQuery(name = "Participant.findByNameOrLastname", query = "from Participant where name = :name or lastname = :lastname"),
		@NamedQuery(name = "Participant.findByEmail", query = "from Participant where email = :email") })
@Entity(name = "Participant")
@Table(name = "participant", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class ParticipantHibernate implements Participant {

	private static final long serialVersionUID = 3565644386767589142L;

	@Id
	@SequenceGenerator(name = "gen_participant_id", sequenceName = "seq_participant_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_participant_id")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "lastname", nullable = false, length = 30)
	private String lastname;

	@Column(name = "position", nullable = false, length = 30)
	private String position;

	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "participant")
	private Set<ProgramHibernate> programs = new HashSet<ProgramHibernate>(0);

	public ParticipantHibernate() {
	}

	public ParticipantHibernate(Long id, String name, String lastname, String position, String email) {
		setId(id);
		setName(name);
		setLastname(lastname);
		setPosition(position);
		setEmail(email);
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
	public Set<ProgramHibernate> getPrograms() {
		return programs;
	}

	@Override
	public void setPrograms(Set<? extends Program> programs) {
		this.programs = (Set<ProgramHibernate>) programs;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", lastname=" + lastname
				+ ", position=" + position + ", email=" + email + "]";
	}

}
