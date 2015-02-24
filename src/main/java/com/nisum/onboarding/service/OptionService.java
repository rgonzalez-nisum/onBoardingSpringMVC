package com.nisum.onboarding.service;

import java.util.Collection;
import java.util.List;

import com.nisum.onboarding.bo.OptionBo;
import com.nisum.onboarding.bo.SerializableBo;
import com.nisum.onboarding.exception.BeanException;

public interface OptionService<T extends OptionBo, S extends SerializableBo> {

	public List<T> toOptions(Collection<S> bos) throws BeanException;
	
}
