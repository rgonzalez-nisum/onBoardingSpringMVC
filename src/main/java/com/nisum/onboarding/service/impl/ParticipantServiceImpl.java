package com.nisum.onboarding.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.bean.JTableOptionBean;
import com.nisum.onboarding.jtable.bean.JTableParticipantBean;
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
	public void save(JTableParticipantBean participant) throws BeanException {
		try {
			participantDao.save(participant.toParticipant());
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + participant;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(JTableParticipantBean participant) throws BeanException {
		try {
			participantDao.update(participant.toParticipant());
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + participant;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(JTableParticipantBean participant) throws BeanException {
		try {
			participantDao.delete(participant.toParticipant());
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting " + participant;
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
	public List<JTableParticipantBean> findAll() throws BeanException {
		try {
			return toJTableParticipantBeans(participantDao.findAll());
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all participants";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public JTableParticipantBean findById(Long id) throws BeanException {
		try {
			return toJTableParticipantBean(participantDao.findById(id));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public JTableParticipantBean findByEmail(String email) throws BeanException {
		try {
			return toJTableParticipantBean(participantDao.findByEmail(email));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by Email=" + email;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<JTableParticipantBean> findByNameOrLastname(String nameOrLastname) throws BeanException {
		try {
			return toJTableParticipantBeans(participantDao.findByNameOrLastname(nameOrLastname));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by Name or Lastname=" + nameOrLastname;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	public List<JTableOptionBean> findAllAsOptions() throws BeanException {
		List<JTableOptionBean> options = new ArrayList<JTableOptionBean>();
		
		for (JTableParticipantBean participant : findAll()) {
			String displayText = participant.getName() + " " + participant.getLastname();
			options.add(new JTableOptionBean(displayText, participant.getId()));
		}

		return options;
	}
	
	private JTableParticipantBean toJTableParticipantBean(Participant participant) {
		return new JTableParticipantBean(participant);
	}


	private List<JTableParticipantBean> toJTableParticipantBeans(List<Participant> participants) {
		List<JTableParticipantBean> participantBeans = new ArrayList<JTableParticipantBean>();
		
		for (Participant participant : participants) {
			participantBeans.add(toJTableParticipantBean(participant));
		}
		
		return participantBeans;
	}

}