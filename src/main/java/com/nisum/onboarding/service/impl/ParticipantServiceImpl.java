package com.nisum.onboarding.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.exception.ParticipantException;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	private static final Logger LOG = Logger.getLogger(ParticipantServiceImpl.class);

	@Autowired
	private ParticipantDao participantDao;

	public ParticipantServiceImpl() {
	}

	public ParticipantServiceImpl(ParticipantDao participantDao) {
		this.participantDao = participantDao;
	}

	public ParticipantDao getParticipantDao() {
		return participantDao;
	}

	public void setParticipantDao(ParticipantDao participantDao) {
		this.participantDao = participantDao;
	}

	@Override
	@Transactional
	public void save(Participant participant) throws ParticipantException {
		try {
			participantDao.save(participant);
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + participant;
			LOG.error(message, e);
			throw new ParticipantException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(Participant participant) throws ParticipantException {
		try {
			participantDao.update(participant);
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + participant;
			LOG.error(message, e);
			throw new ParticipantException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(Participant participant) throws ParticipantException {
		try {
			participantDao.delete(participant);
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting " + participant;
			LOG.error(message, e);
			throw new ParticipantException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Participant> findAll() throws ParticipantException {
		try {
			return participantDao.findAll();
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all participants";
			LOG.error(message, e);
			throw new ParticipantException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Participant findById(Long id) throws ParticipantException {
		try {
			return findById(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by ID=" + id;
			LOG.error(message, e);
			throw new ParticipantException(message, e);
		}
	}

}