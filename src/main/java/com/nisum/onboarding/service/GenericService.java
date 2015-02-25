package com.nisum.onboarding.service;

import java.io.Serializable;
import java.util.List;

import com.nisum.onboarding.dto.SerializableDto;
import com.nisum.onboarding.exception.BeanException;

public interface GenericService<DTO extends SerializableDto, ID extends Serializable> {

	public void save(DTO bo) throws BeanException;

	public void update(DTO bo) throws BeanException;

	public void delete(ID id) throws BeanException;

	public List<DTO> findAll() throws BeanException;

	public DTO findById(ID id) throws BeanException;
	
}
