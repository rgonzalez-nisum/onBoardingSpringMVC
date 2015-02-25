package com.nisum.onboarding.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.bo.ParticipantBo;
import com.nisum.onboarding.dto.OptionDto;
import com.nisum.onboarding.dto.ParticipantDto;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	private static final Logger LOG = Logger.getLogger(ParticipantServiceImpl.class);

	@Autowired
	private ParticipantBo participantBo;

	public ParticipantServiceImpl() {
	}

	public ParticipantServiceImpl(ParticipantBo participantBo) {
		setParticipantBo(participantBo);
	}

	@Override
	public ParticipantBo getParticipantBo() {
		return participantBo;
	}

	@Override
	public void setParticipantBo(ParticipantBo participantBo) {
		this.participantBo = participantBo;
	}

	@Override
	@Transactional
	public void save(ParticipantDto participantDto) throws BeanException {
		try {
			participantBo.save(participantDto);
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + participantDto;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(ParticipantDto participantDto) throws BeanException {
		try {
			participantBo.update(participantDto);
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + participantDto;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) throws BeanException {
		try {
			participantBo.delete(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting participant ID " + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ParticipantDto> findAll() throws BeanException {
		try {
			return participantBo.findAll();
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all participants";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ParticipantDto findById(Long id) throws BeanException {
		try {
			return participantBo.findById(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ParticipantDto findByEmail(String email) throws BeanException {
		try {
			return participantBo.findByEmail(email);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by Email=" + email;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ParticipantDto> findByNameOrLastname(String nameOrLastname) throws BeanException {
		try {
			return participantBo.findByNameOrLastname(nameOrLastname);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding participant by Name or Lastname=" + nameOrLastname;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	public List<OptionDto> toOptions(Collection<ParticipantDto> dtos) throws BeanException {
		List<OptionDto> options = new ArrayList<OptionDto>();
		
		for (ParticipantDto participant : dtos) {
			String displayText = participant.getName() + " " + participant.getLastname();
			options.add(new OptionDto(displayText, participant.getId()));
		}

		return options;
	}

}