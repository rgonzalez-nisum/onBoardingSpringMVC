package com.nisum.onboarding.bo;

import java.io.Serializable;
import java.util.List;

import com.nisum.onboarding.dto.SerializableDto;

public interface GenericBo<DTO extends SerializableDto, ID extends Serializable> {

	public void save(DTO dto);

	public void update(DTO dto);

	public void delete(ID id);

	public List<DTO> findAll();

	public DTO findById(ID id);
	
}
