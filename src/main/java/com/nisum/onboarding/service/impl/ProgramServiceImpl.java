package com.nisum.onboarding.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.bo.impl.OptionBoImpl;
import com.nisum.onboarding.bo.impl.hibernate.ProgramBoHibernateImpl;
import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.model.hibernate.ProgramHibernate;
import com.nisum.onboarding.service.ProgramService;

@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class ProgramServiceImpl implements ProgramService<ProgramBoHibernateImpl> {

	private static final Logger LOG = Logger.getLogger(ProgramServiceImpl.class);

	@Autowired
	private ProgramDao<ProgramHibernate> programDao;

	public ProgramServiceImpl() {
	}

	public ProgramServiceImpl(ProgramDao<ProgramHibernate> programDao) {
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
	public void save(ProgramBoHibernateImpl programBo) throws BeanException {
		try {
			programDao.save(programBo.toProgram());
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + programBo;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(ProgramBoHibernateImpl programBo) throws BeanException {
		try {
			programDao.update(programBo.toProgram());
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + programBo;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(ProgramBoHibernateImpl programBo) throws BeanException {
		try {
			programDao.delete(programBo.toProgram());
		} catch (Exception e) {
			String message = "An exception has been thrown while deleting " + programBo;
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
	public List<ProgramBoHibernateImpl> findAll() throws BeanException {
		try {
			return toProgramBoList(programDao.findAll());
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all programs";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProgramBoHibernateImpl findById(Long id) throws BeanException {
		try {
			return toProgramBo(programDao.findById(id));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramBoHibernateImpl> findByParticipantId(Long participantId) throws BeanException {
		try {
			return toProgramBoList(programDao.findByParticipantId(participantId));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by participant ID=" + participantId;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramBoHibernateImpl> findByStatus(ProgramStatus status) throws BeanException {
		try {
			return toProgramBoList(programDao.findByStatus(status));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by status=" + status;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	@Override
	public List<OptionBoImpl> toOptions(Collection<ProgramBoHibernateImpl> bos) throws BeanException {
		List<OptionBoImpl> options = new ArrayList<OptionBoImpl>();
		
		for (ProgramBoHibernateImpl program : bos) {
			options.add(new OptionBoImpl(program.getDescription(), program.getId()));
		}

		return options;
	}
	
	private ProgramBoHibernateImpl toProgramBo(ProgramHibernate program) {
		return new ProgramBoHibernateImpl(program);
	}

	private List<ProgramBoHibernateImpl> toProgramBoList(List<ProgramHibernate> programs) {
		List<ProgramBoHibernateImpl> programBeans = new ArrayList<ProgramBoHibernateImpl>();
		
		for (ProgramHibernate program : programs) {
			programBeans.add(new ProgramBoHibernateImpl((ProgramHibernate) program));
		}
		
		return programBeans;
	}

}
