package com.nisum.onboarding.service;

import java.util.List;

import com.nisum.onboarding.exception.BeanException;
import com.nisum.onboarding.jtable.bean.JTableOptionBean;

public interface OptionService {

	public List<JTableOptionBean> findAllAsOptions() throws BeanException;
	
}
