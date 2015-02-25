package com.nisum.onboarding.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nisum.onboarding.bo.ParticipantBo;
import com.nisum.onboarding.dao.ParticipantDao;
import com.nisum.onboarding.dto.ParticipantDto;

@Component
public class ParticipantBoImpl implements ParticipantBo {

	@Autowired
	private ParticipantDao participantDao;

	@Override
	public void save(ParticipantDto dto) {
		participantDao.save(dto);
	}

	@Override
	public void update(ParticipantDto dto) {
		participantDao.update(dto);
	}

	@Override
	public void delete(Long id) {
		participantDao.deleteById(id);
	}

	@Override
	public List<ParticipantDto> findAll() {
		return participantDao.findAll();
	}

	@Override
	public ParticipantDto findById(Long id) {
		return participantDao.findById(id);
	}

	@Override
	public ParticipantDto findByEmail(String email) {
		return participantDao.findByEmail(email);
	}

	@Override
	public List<ParticipantDto> findByNameOrLastname(String nameOrLastname) {
		return participantDao.findByNameOrLastname(nameOrLastname);
	}
	
}
