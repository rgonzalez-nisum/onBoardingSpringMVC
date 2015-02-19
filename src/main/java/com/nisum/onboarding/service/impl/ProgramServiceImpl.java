package com.nisum.onboarding.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.bean.JTableProgramBean;
import com.nisum.onboarding.model.Program;
import com.nisum.onboarding.model.ProgramStatus;
import com.nisum.onboarding.service.ProgramService;

@Service
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
	public void save(JTableProgramBean program) throws BeanException {
		try {
			programDao.save(program.toProgram());
		} catch (Exception e) {
			String message = "An exception has been thrown while saving " + program;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void update(JTableProgramBean program) throws BeanException {
		try {
			programDao.update(program.toProgram());
		} catch (Exception e) {
			String message = "An exception has been thrown while updating " + program;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional
	public void delete(JTableProgramBean program) throws BeanException {
		try {
			programDao.delete(program.toProgram());
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
	public List<JTableProgramBean> findAll() throws BeanException {
		try {
			return toJTableProgramBeans(programDao.findAll());
		} catch (Exception e) {
			String message = "An exception has been thrown while finding all programs";
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public JTableProgramBean findById(Long id) throws BeanException {
		try {
			return toJTableProgramBean(programDao.findById(id));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by ID=" + id;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	public List<JTableProgramBean> findByParticipantId(Long participantId) throws BeanException {
		try {
			return toJTableProgramBeans(programDao.findByParticipantId(participantId));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by participant ID=" + participantId;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}

	@Override
	public List<JTableProgramBean> findByStatus(ProgramStatus status) throws BeanException {
		try {
			return toJTableProgramBeans(programDao.findByStatus(status));
		} catch (Exception e) {
			String message = "An exception has been thrown while finding program by status=" + status;
			LOG.error(message, e);
			throw new BeanException(message, e);
		}
	}
	
	private JTableProgramBean toJTableProgramBean(Program program) {
		return new JTableProgramBean(program);
	}


	private List<JTableProgramBean> toJTableProgramBeans(List<Program> programs) {
		List<JTableProgramBean> programBeans = new ArrayList<JTableProgramBean>();
		
		for (Program program : programs) {
			programBeans.add(toJTableProgramBean(program));
		}
		
		return programBeans;
	}

}
