package com.nisum.onboarding.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.bo.impl.OptionBoImpl;
import com.nisum.onboarding.bo.impl.hibernate.ParticipantBoHibernateImpl;
import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.Participant;
import com.nisum.onboarding.model.hibernate.ParticipantHibernate;
import com.nisum.onboarding.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService<ParticipantBoHibernateImpl> {

	private static final Logger LOG = Logger.getLogger(ParticipantServiceImpl.class);

	@Autowired
	private ParticipantDao participantDao;

	public ParticipantServiceImpl() {
	}

	public ParticipantServiceImpl(ParticipantDao participantDao) {
		this.participantDao = participantDao;
	}

	@Override
	public ParticipantDao getParticipantDao() {
		return participantDao;
	}

	@Override
	public void setParticipantDao(ParticipantDao participantDao) {
		this.participantDao = participantDao;
	}

	@Override
	@Transactional
	public void save(ParticipantBoHibernateImpl participantBo) throws BeanException {
		try {
			participantDao.save(participantBo.toParticipant());
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + participantBo;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(ParticipantBoHibernateImpl participantBo) throws BeanException {
		try {
			participantDao.update(participantBo.toParticipant());
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + participantBo;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(ParticipantBoHibernateImpl participantBo) throws BeanException {
		try {
			participantDao.delete(participantBo.toParticipant());
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting " + participantBo;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) throws BeanException {
		try {
			participantDao.deleteById(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting participant ID " + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ParticipantBoHibernateImpl> findAll() throws BeanException {
		try {
			return toParticipantBoList(participantDao.findAll());
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all participants";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ParticipantBoHibernateImpl findById(Long id) throws BeanException {
		try {
			return toParticipantBo(participantDao.findById(id));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ParticipantBoHibernateImpl findByEmail(String email) throws BeanException {
		try {
			return toParticipantBo(participantDao.findByEmail(email));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by Email=" + email;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ParticipantBoHibernateImpl> findByNameOrLastname(String nameOrLastname) throws BeanException {
		try {
			return toParticipantBoList(participantDao.findByNameOrLastname(nameOrLastname));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by Name or Lastname=" + nameOrLastname;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	public List<OptionBoImpl> findAllAsOptions() throws BeanException {
		List<OptionBoImpl> options = new ArrayList<OptionBoImpl>();
		
		for (ParticipantBoHibernateImpl participant : findAll()) {
			String displayText = participant.getName() + " " + participant.getLastname();
			options.add(new OptionBoImpl(displayText, participant.getId()));
		}

		return options;
	}
	
	private ParticipantBoHibernateImpl toParticipantBo(Participant paticipant) {
		return new ParticipantBoHibernateImpl((ParticipantHibernate) paticipant);
	}
	
	private List<ParticipantBoHibernateImpl> toParticipantBoList(List<Participant> participants) {
		List<ParticipantBoHibernateImpl> participantBeans = new ArrayList<ParticipantBoHibernateImpl>();
		
		for (Participant participant : participants) {
			participantBeans.add(toParticipantBo(participant));
		}
		
		return participantBeans;
	}

}