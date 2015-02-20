package com.nisum.onboarding.service;

import java.io.Serializable;
import java.util.List;

import com.nisum.onboarding.bo.SerializableBo;
import com.nisum.onboarding.exception.BeanException;

public interface GenericService<T extends SerializableBo, ID extends Serializable> {

	public void save(T t) throws BeanException;
	
	public void update(T t) throws BeanException;
	
	public void delete(T t) throws BeanException;
	
	public void deleteById(ID id) throws BeanException;
	
	public List<T> findAll() throws BeanException;
	
	public T findById(ID id) throws BeanException;
	
}
