package com.nisum.onboarding.service;

import java.util.Collection;
import java.util.List;

import com.nisum.onboarding.dto.OptionDto;
import com.nisum.onboarding.dto.SerializableDto;
import com.nisum.onboarding.exception.BeanException;

public interface Optionable<DTO extends SerializableDto> {

	public List<OptionDto> toOptions(Collection<DTO> dtos) throws BeanException;
	
}
