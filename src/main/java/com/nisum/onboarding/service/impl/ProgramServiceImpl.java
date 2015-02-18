package com.nisum.onboarding.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.service.ProgramService;

public class ProgramServiceImpl implements ProgramService {

	private static final Logger LOG = Logger.getLogger(ProgramServiceImpl.class);

	@Autowired
	private ProgramDao programDao;

	public ProgramServiceImpl() {
	}

	public ProgramServiceImpl(ProgramDao programDao) {
		this.programDao = programDao;
	}

	@Override
	public ProgramDao getProgramDao() {
		return programDao;
	}

	@Override
	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}

	@Override
	@Transactional
	public void save(Program program) throws BeanException {
		try {
			programDao.save(program);
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + program;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(Program program) throws BeanException {
		try {
			programDao.update(program);
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + program;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(Program program) throws BeanException {
		try {
			programDao.delete(program);
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting " + program;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) throws BeanException {
		try {
			programDao.deleteById(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting program ID " + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Program> findAll() throws BeanException {
		try {
			return programDao.findAll();
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all programs";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Program findById(Long id) throws BeanException {
		try {
			return findById(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	public List<Program> findByParticipantId(Long id) throws BeanException {
		try {
			return findByParticipantId(id);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by participant ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	public List<Program> findByStatus(ProgramStatus status) throws BeanException {
		try {
			return findByStatus(status);
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by status=" + status;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

}
