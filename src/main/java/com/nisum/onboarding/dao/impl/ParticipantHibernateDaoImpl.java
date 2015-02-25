package com.nisum.onboarding.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.AbstractHibernateDao;
import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.dto.ParticipantDto;
import com.nisum.onboarding.dto.ProgramDto;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.hibernate.ParticipantHibernate;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ParticipantHibernateDaoImpl extends AbstractHibernateDao<ParticipantDto, Long> implements ParticipantDao {

	private static final Logger LOG = Logger.getLogger(ParticipantHibernateDaoImpl.class);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public ParticipantHibernateDaoImpl() {
		super(ParticipantHibernate.class);
	}

	@Override
	public ParticipantDto findByEmail(String email) {
		List<Serializable> results = getSession().getNamedQuery(getEntityName() + ".findByEmail")
				.setParameter("email", email)
				.list();

		return !results.isEmpty() ? persistentToDto(results.get(0)) : null;
	}

	@Override
	public List<ParticipantDto> findByNameOrLastname(String nameOrLastname) {
		List<Serializable> results = getSession().getNamedQuery(getEntityName() + ".findByNameOrLastname")
				.setParameter("name", nameOrLastname)
				.setParameter("lastname", nameOrLastname)
				.list();
		
		return persistentsToDtos(results);
	}

	@Override
	protected Serializable dtoToPersistent(ParticipantDto participantDto) {
		if (participantDto == null)
			return null;
		
		ParticipantHibernate participant = new ParticipantHibernate();
		participant.setId(participantDto.getId());
		participant.setName(participantDto.getName());
		participant.setLastname(participantDto.getLastname());
		participant.setPosition(participantDto.getPosition());
		participant.setEmail(participantDto.getEmail());
		participant.setPrograms(toPrograms(participantDto.getPrograms()));
		
		return participant;
	}

	@Override
	protected ParticipantDto persistentToDto(Serializable persistent) {
		if (persistent == null || !(persistent instanceof ParticipantHibernate))
			return null;
		
		ParticipantHibernate participant = (ParticipantHibernate) persistent;
		
		ParticipantDto participantDto = new ParticipantDto();
		participantDto.setId(participant.getId());
		participantDto.setName(participant.getName());
		participantDto.setLastname(participant.getLastname());
		participantDto.setPosition(participant.getPosition());
		participantDto.setEmail(participant.getEmail());
		participantDto.setPrograms(toProgramDtos(participant.getPrograms()));
		
		return participantDto;
	}
	
	private Set<ProgramDto> toProgramDtos(Set<ProgramHibernate> programs) {
		if (programs == null || programs.isEmpty())
			return new HashSet<ProgramDto>(0);

		Set<ProgramDto> programDtos = new HashSet<ProgramDto>(programs.size());
		for (Program program : programs) {
			ProgramDto programDto = new ProgramDto();
			programDto.setId(program.getId());
			programDto.setParticipant(program.getParticipant().getId());
			programDto.setDescription(program.getDescription());
			programDto.setStatus(program.getStatus());
			programDto.setStarted(DATE_FORMAT.format(program.getStarted()));
			
			programDtos.add(programDto);
		}

		return programDtos;
	}

	private Set<ProgramHibernate> toPrograms(Set<ProgramDto> programDtos) {
		if (programDtos == null || programDtos.isEmpty())
			return new HashSet<ProgramHibernate>(0);

		Set<ProgramHibernate> programs = new HashSet<ProgramHibernate>(programDtos.size());
		for (ProgramDto programDto : programDtos) {
			ParticipantHibernate participant = new ParticipantHibernate();
			participant.setId(programDto.getParticipant());
			
			ProgramHibernate program = new ProgramHibernate();
			program.setId(programDto.getId());
			program.setParticipant(participant);
			program.setDescription(programDto.getDescription());
			program.setStatus(programDto.getStatus());
			try {
				program.setStarted(DATE_FORMAT.parse(programDto.getStarted()));
			} catch(ParseException e) {
				LOG.error("Exception parsing Program started date", e);
			}
			
			programs.add(program);
		}

		return programs;
	}

}
