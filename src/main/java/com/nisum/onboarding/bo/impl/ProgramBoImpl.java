package com.nisum.onboarding.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nisum.onboarding.bo.ProgramBo;
import com.nisum.onboarding.dao.ProgramDao;
import com.nisum.onboarding.dto.ProgramDto;
import com.nisum.onboarding.model.ProgramStatus;

@Component
public class ProgramBoImpl implements ProgramBo {

	@Autowired
	private ProgramDao programDao;
	
	@Override
	public void save(ProgramDto dto) {
		programDao.save(dto);
	}

	@Override
	public void update(ProgramDto dto) {
		programDao.update(dto);
	}

	@Override
	public void delete(Long id) {
		programDao.deleteById(id);
	}

	@Override
	public List<ProgramDto> findAll() {
		return programDao.findAll();
	}

	@Override
	public ProgramDto findById(Long id) {
		return programDao.findById(id);
	}

	@Override
	public List<ProgramDto> findByParticipantId(Long participantId) {
		return programDao.findByParticipantId(participantId);
	}

	@Override
	public List<ProgramDto> findByStatus(ProgramStatus status) {
		return programDao.findByStatus(status);
	}

}
