package com.nisum.onboarding.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "Participant.findAll", query = "from Participant"),
	@NamedQuery(name = "Participant.findByNameOrLastname", query = "from Participant where name = :name or lastname = :lastname"),
	@NamedQuery(name = "Participant.findByEmail", query = "from Participant where email = :email") 
})
@Entity
@Table(name = "participant", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Participant implements Serializable {

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

	public Participant() {
	}

	public Participant(Long id, String name, String lastname, String position, String email) {
		setId(id);
		setName(name);
		setLastname(lastname);
		setPosition(position);
		setEmail(email);
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

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", lastname=" + lastname
				+ ", position=" + position + ", email=" + email + "]";
	}

}
