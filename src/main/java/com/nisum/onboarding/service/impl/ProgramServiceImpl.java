package com.nisum.onboarding.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.bo.ProgramBo;
import com.nisum.onboarding.dto.OptionDto;
import com.nisum.onboarding.dto.ProgramDto;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {

	private static final Logger LOG = Logger.getLogger(ProgramServiceImpl.class);

	@Autowired
	private ProgramBo programBo;

	public ProgramServiceImpl() {
	}

	public ProgramServiceImpl(ProgramBo programBo) {
		setProgramBo(programBo);
	}

	@Override
	public ProgramBo getProgramBo() {
		return programBo;
	}

	@Override
	public void setProgramBo(ProgramBo programBo) {
		this.programBo = programBo;
	}

	@Override
	@Transactional
	public void save(ProgramDto programDto) throws BeanException {
		try {
			programBo.save(programDto);
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + programDto;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(ProgramDto programDto) throws BeanException {
		try {
			programBo.update(programDto);
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + programDto;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	@Transactional
	public void delete(Long id) throws BeanException {
		try {
			programBo.delete(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting program ID " + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramDto> findAll() throws BeanException {
		try {
			return programBo.findAll();
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all programs";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProgramDto findById(Long id) throws BeanException {
		try {
			return programBo.findById(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramDto> findByParticipantId(Long participantId) throws BeanException {
		try {
			return programBo.findByParticipantId(participantId);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by participant ID=" + participantId;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramDto> findByStatus(ProgramStatus status) throws BeanException {
		try {
			return programBo.findByStatus(status);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by status=" + status;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	public List<OptionDto> toOptions(Collection<ProgramDto> dtos) throws BeanException {
		List<OptionDto> options = new ArrayList<OptionDto>();
		
		for (ProgramDto program : dtos) {
			options.add(new OptionDto(program.getDescription(), program.getId()));
		}

		return options;
	}
	
}
