package com.nisum.onboarding.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.AbstractHibernateDao;
import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.dto.ProgramDto;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.model.hibernate.ParticipantHibernate;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ProgramHibernateDaoImpl extends AbstractHibernateDao<ProgramDto, Long> implements ProgramDao {

	private static final Logger LOG = Logger.getLogger(ProgramHibernateDaoImpl.class);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public ProgramHibernateDaoImpl() {
		super(ProgramHibernate.class);
	}

	@Override
	public List<ProgramDto> findByParticipantId(Long participantId) {
		List<Serializable> results = getSession().getNamedQuery(getEntityName() + ".findByParticipantId")
				.setParameter("participantId", participantId)
				.list();
		
		return persistentsToDtos(results);
	}

	@Override
	public List<ProgramDto> findByStatus(ProgramStatus status) {
		List<Serializable> results = getSession().getNamedQuery(getEntityName() + ".findByStatus")
				.setParameter("status", status)
				.list();
		
		return persistentsToDtos(results);
	}

	@Override
	protected Serializable dtoToPersistent(ProgramDto programDto) {
		if (programDto == null)
			return null;
		
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
		
		return program;
	}

	@Override
	protected ProgramDto persistentToDto(Serializable persistent) {
		if (persistent == null || !(persistent instanceof ProgramHibernate))
			return null;
		
		ProgramHibernate program = (ProgramHibernate) persistent;
		ProgramDto programDto = new ProgramDto();
		programDto.setId(program.getId());
		programDto.setParticipant(program.getParticipant().getId());
		programDto.setDescription(program.getDescription());
		programDto.setStatus(program.getStatus());
		programDto.setStarted(DATE_FORMAT.format(program.getStarted()));
		
		return programDto;
	}

}
