package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.bo.OptionBo;
import com.nisum.onboarding.exception.BeanException;

public interface OptionService<T extends OptionBo> {

	public List<T> findAllAsOptions() throws BeanException;
	
}
